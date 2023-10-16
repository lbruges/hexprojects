package galaxy.hexagonal.arch.inventory.application.port.out.inventory;

import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.AddVehiclePort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.CreateModelPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.CreateProductPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.GetAllProductsPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops.VerifyModelPort;

// TODO: Move to commons.
public abstract class GenericInventoryPort implements AddVehiclePort, CreateModelPort, CreateProductPort,
        GetAllProductsPort, VerifyModelPort {
}
