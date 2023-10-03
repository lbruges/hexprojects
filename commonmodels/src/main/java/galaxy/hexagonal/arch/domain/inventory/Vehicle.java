package galaxy.hexagonal.arch.domain.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Vehicle {

    private VehicleModel model;
    private double rentalPrice;

}
