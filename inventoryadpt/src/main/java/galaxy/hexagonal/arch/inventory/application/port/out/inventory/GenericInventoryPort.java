package galaxy.hexagonal.arch.inventory.application.port.out.inventory;

import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.AddVehiclePort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.CreateModelPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.CreateProductPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.GetAllModelsPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.GetAllProductsPort;

public abstract class GenericInventoryPort implements CreateModelPort, GetAllModelsPort, AddVehiclePort,
        CreateProductPort, GetAllProductsPort {
}
