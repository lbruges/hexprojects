package galaxy.hexagonal.arch.domain.rental;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.inventory.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class RentedVehicle extends Vehicle {
    private String plate;
    private RentalPeriod rentalPeriod;
}
