package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddProductUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddVehicleUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.GetAllProductsUseCase;

public abstract class InventoryService implements AddProductUseCase, AddVehicleUseCase, GetAllProductsUseCase {
}
