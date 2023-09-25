package galaxy.hexagonal.arch.domain.rental;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.Vehicle;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(callSuper = true)
public class RentedVehicle extends Vehicle {
    private String plate;
    private RentalPeriod rentalPeriod;
}
