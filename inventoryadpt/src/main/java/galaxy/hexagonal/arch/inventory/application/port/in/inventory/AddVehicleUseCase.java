package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;

public interface AddVehicleUseCase {

    void addVehicleToCatalog(InventoryVehicleItem vehicleItem);
}
