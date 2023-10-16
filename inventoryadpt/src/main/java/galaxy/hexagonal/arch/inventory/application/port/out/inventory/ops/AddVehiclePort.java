package galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;

public interface AddVehiclePort {

    void addVehicle(InventoryVehicleItem vehicleItem);

}
