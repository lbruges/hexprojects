package galaxy.hexagonal.arch.inventory.application.port.out.rental.ops;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;

public interface RentVehiclePort {

    RentedVehicle completeRental(String freezeCode, Renter renter, Period rentalPeriod);

}
