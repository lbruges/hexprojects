package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProductRequest;

public interface AddProductUseCase {
    void addProductToCatalog(VehicleProductRequest product);
}
