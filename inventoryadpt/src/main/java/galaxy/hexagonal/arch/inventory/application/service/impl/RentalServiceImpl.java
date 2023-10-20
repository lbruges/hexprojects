package galaxy.hexagonal.arch.inventory.application.service.impl;

import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;
import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.out.billing.GenericBillingPort;
import galaxy.hexagonal.arch.inventory.application.port.out.rental.GenericRentalPort;
import galaxy.hexagonal.arch.inventory.application.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl extends RentalService {

    private final GenericRentalPort rentalPort;
    private final GenericBillingPort billingPort;

    @Override
    public RentedVehicle finalizeRental(String freezeCode, Renter renter, Period rentalPeriod) {
        try {
            return rentalPort.completeRental(freezeCode, renter, rentalPeriod);
        } catch (Exception e) {
            throw new InventoryException(ErrorType.UNABLE_TO_COMPLETE_RENT, e);
        }
    }

    @Override
    public ReturnedVehicle returnVehicle(String vehiclePlate, Renter renter) {
        try {
            ReturnedVehicle vehicle = rentalPort.returnVehicle(vehiclePlate, renter);
            billingPort.reportToBilling(vehicle);

            return vehicle;
        } catch (Exception e) {
            throw new InventoryException(ErrorType.UNABLE_TO_RETURN_VEHICLE, e);
        }
    }
}
