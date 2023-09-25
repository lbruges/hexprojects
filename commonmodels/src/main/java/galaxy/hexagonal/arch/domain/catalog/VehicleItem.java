package galaxy.hexagonal.arch.domain.catalog;

import galaxy.hexagonal.arch.domain.Vehicle;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VehicleItem extends Vehicle {
    private String code;
    private int availableUnits;
    private double price;
}
