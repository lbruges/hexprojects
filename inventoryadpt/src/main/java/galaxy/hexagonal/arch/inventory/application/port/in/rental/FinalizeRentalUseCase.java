package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.util.Period;

public interface FinalizeRentalUseCase {
    RentedVehicle finalizeRental(String freezeCode, Renter renter, Period rentalPeriod);
}
