package galaxy.hexagonal.arch.inventory.adapter.out;


import galaxy.hexagonal.arch.inventory.application.port.out.inventory.CreateModelPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.CreateProductPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.VerifyModelPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.GetAllProductsPort;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.AddVehiclePort;

public abstract class InventoryAdapter implements AddVehiclePort, CreateModelPort, CreateProductPort, GetAllProductsPort, VerifyModelPort {
}
