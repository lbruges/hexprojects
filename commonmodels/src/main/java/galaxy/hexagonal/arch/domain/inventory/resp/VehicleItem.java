package galaxy.hexagonal.arch.domain.inventory.resp;

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
public class VehicleItem extends Vehicle {
    private String sku;
    private int availableUnits;
}
