package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.FreezeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.GetFreezeUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.RollbackFreezeUseCase;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.GenericFreezePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FreezeService implements FreezeRentalUseCase, GetFreezeUseCase, RollbackFreezeUseCase {

    private final GenericFreezePort freezePort;

    @Override
    public FrozenInventory freezeRental(String sku, Period freezePeriod) throws InventoryException {
        return freezePort.freezeVehicle(sku, freezePeriod.getDuration().toMinutesPart(),
                freezePeriod.getStartDateTime());
    }

    @Override
    public FrozenInventory getFreeze(String freezeCode) {
        return freezePort.getFreeze(freezeCode);
    }

    @Override
    public void rollbackRental(String freezeCode) throws InventoryException {
        freezePort.thawVehicle(freezeCode);
    }
}
