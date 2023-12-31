package galaxy.hexagonal.arch.inventory.adapter.out.mysql;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.domain.util.IdGenerator;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Freeze;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RentableVehicleMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.FreezeRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.VehicleRepository;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.GenericFreezePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

import static galaxy.hexagonal.arch.inventory.adapter.out.mysql.Constants.SINGLE_RESULT_PAGE;

@RequiredArgsConstructor
public class MySqlFreezeAdapter extends GenericFreezePort {

    private final VehicleRepository vehicleRepository;
    private final FreezeRepository freezeRepository;

    private final RentableVehicleMapper rentableVehicleMapper;

    @Override
    @Transactional
    public FrozenInventory freezeVehicle(String sku, int freezeTimeInMins, LocalDateTime freezeStart) {
        LocalDateTime freezeTime = Optional.ofNullable(freezeStart).orElse(LocalDateTime.now());
        Freeze vehicleFreeze = null;

        try {
            Freeze toFreeze = Freeze.builder()
                    .freezeCode(IdGenerator.generateId())
                    .freezeDate(freezeTime)
                    .freezeTimeInMin(freezeTimeInMins)
                    .build();

            vehicleFreeze = freezeRepository.save(toFreeze);

            Vehicle rentCandidate = vehicleRepository.getVehiclesToFreeze(SINGLE_RESULT_PAGE, sku).stream()
                    .findFirst()
                    .orElseThrow(() -> new InventoryException(ErrorType.RAN_OUT_OF_INVENTORY));

            rentCandidate.setFreeze(vehicleFreeze);
            vehicleRepository.save(rentCandidate);

            return FrozenInventory.builder()
                    .freezeCode(vehicleFreeze.getFreezeCode())
                    .vehicleItem(rentableVehicleMapper.toDomain(rentCandidate))
                    .build();
        } catch (Exception e) {
            if (vehicleFreeze != null) {
                freezeRepository.delete(vehicleFreeze);
            }
            throw new InventoryException(ErrorType.FAILED_TO_FREEZE, e);
        }
    }

    public FrozenInventory freezeVehicle(String sku, int freezeTimeInMins) {
        return freezeVehicle(sku, freezeTimeInMins, null);
    }

    @Override
    public FrozenInventory getFreeze(String freezeCode) {
        Freeze freeze = Optional.ofNullable(freezeRepository.findByFreezeCode(freezeCode))
                .orElseThrow(() -> new InventoryException(ErrorType.FREEZE_NOT_FOUND));

        return FrozenInventory.builder()
                .freezeCode(freeze.getFreezeCode())
                .vehicleItem(rentableVehicleMapper.toDomain(freeze.getVehicle()))
                .build();
    }

    @Override
    @Transactional
    public void thawVehicle(String freezeCode) {
        try {
            Freeze freezeEntity = Optional.ofNullable(freezeRepository.findByFreezeCode(freezeCode))
                    .orElseThrow(() -> new InventoryException(ErrorType.FREEZE_NOT_FOUND));

            Vehicle vehicleEntity = freezeEntity.getVehicle();
            vehicleEntity.setFreeze(null);
            vehicleRepository.save(vehicleEntity);
            freezeRepository.deleteByFreezeCode(freezeCode);
        } catch (Exception e) {
            throw new InventoryException(ErrorType.UNABLE_TO_THAW);
        }
    }
}
