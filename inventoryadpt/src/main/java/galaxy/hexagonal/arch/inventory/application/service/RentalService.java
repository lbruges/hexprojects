package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.FinalizeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.rental.ReturnVehicleUseCase;
import galaxy.hexagonal.arch.inventory.application.port.out.rental.GenericRentalPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RentalService implements FinalizeRentalUseCase, ReturnVehicleUseCase {

    private final GenericRentalPort rentalPort;

    @Override
    public RentedVehicle finalizeRental(String freezeCode, Renter renter, Period rentalPeriod) {
        try {
            return rentalPort.completeRental(freezeCode, renter, rentalPeriod);
        } catch (Exception e) {
            throw new InventoryException(ErrorType.UNABLE_TO_COMPLETE_RENT, e);
        }
    }

    @Override
    public void returnVehicle(String vehiclePlate, Renter renter) {
        try {
            rentalPort.returnVehicle(vehiclePlate, renter);
        } catch (Exception e) {
            throw new InventoryException(ErrorType.UNABLE_TO_RETURN_VEHICLE, e);
        }
    }
}
