package galaxy.hexagonal.arch.domain.inventory;

import galaxy.hexagonal.arch.domain.catalog.VehicleItem;
import lombok.Data;

@Data
public class FrozenInventory {
    private String freezeCode;
    private VehicleItem vehicleItem;
}
