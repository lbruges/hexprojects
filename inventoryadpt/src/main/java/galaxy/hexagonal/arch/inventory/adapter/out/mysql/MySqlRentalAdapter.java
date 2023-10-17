package galaxy.hexagonal.arch.inventory.adapter.out.mysql;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Rental;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Renter;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.entity.Vehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RentedVehicleMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.mapper.RenterMapper;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.RentalRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.RenterRepository;
import galaxy.hexagonal.arch.inventory.adapter.out.mysql.repository.VehicleRepository;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.out.rental.GenericRentalPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MySqlRentalAdapter extends GenericRentalPort {

    private final VehicleRepository vehicleRepository;
    private final RentalRepository rentalRepository;
    private final RenterRepository renterRepository;
    private final RenterMapper renterMapper;
    private final RentedVehicleMapper rentedVehicleMapper;

    @Override
    @Transactional
    public RentedVehicle completeRental(String freezeCode, galaxy.hexagonal.arch.domain.rental.Renter renter, Period rentalPeriod) {
        Vehicle vehicleEntity = vehicleRepository.findByFreezeCode(freezeCode);

        if (vehicleEntity == null) {
            throw new InventoryException(ErrorType.RENT_FREEZE_MISMATCH);
        }

        Renter renterEntity = renterRepository.findByIdDocumentAndOriginAndLicence(renter.getDni(), renter.getOrigin(),
                renter.getLicenceNumber());

        if (renterEntity == null) {
            renterRepository.save(renterMapper.toEntity(renter));
        }

        Rental rental = Rental.builder()
                .renter(renterEntity)
                .rentalStartDate(rentalPeriod.getStartDateTime())
                .rentalEndDate(rentalPeriod.getStartDateTime().plus(rentalPeriod.getDuration()))
                .build();

        rentalRepository.save(rental);
        vehicleEntity.setRental(rental);
        vehicleRepository.save(vehicleEntity);

        return rentedVehicleMapper.toDomain(vehicleEntity);
    }

    @Override
    @Transactional
    public void returnVehicle(String plate, galaxy.hexagonal.arch.domain.rental.Renter renter) {
        if (!vehicleRepository.vehicleAndRenterMatch(plate, renter)) {
            throw new InventoryException(ErrorType.RENTER_VEHICLE_MISMATCH);
        }

        Vehicle vehicleEntity = vehicleRepository.findByPlate(plate);
        Rental rental = vehicleEntity.getRental();
        vehicleEntity.setRental(null);
        vehicleRepository.save(vehicleEntity);
        rentalRepository.delete(rental);
    }
}
