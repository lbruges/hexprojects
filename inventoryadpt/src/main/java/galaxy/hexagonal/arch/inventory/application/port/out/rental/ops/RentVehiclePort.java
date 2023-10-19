package galaxy.hexagonal.arch.inventory.application.port.out.rental.ops;

import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.domain.rental.Renter;
import galaxy.hexagonal.arch.domain.util.Period;

public interface RentVehiclePort {

    RentedVehicle completeRental(String freezeCode, Renter renter, Period rentalPeriod);

}
