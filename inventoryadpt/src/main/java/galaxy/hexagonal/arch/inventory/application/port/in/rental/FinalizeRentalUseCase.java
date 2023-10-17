package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;

public interface FinalizeRentalUseCase {
    RentedVehicle finalizeRental(String freezeCode, Renter renter, Period rentalPeriod);
}
