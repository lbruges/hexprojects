package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;

public interface AddProductUseCase {
    void addProductToCatalog(VehicleProduct product);
}
