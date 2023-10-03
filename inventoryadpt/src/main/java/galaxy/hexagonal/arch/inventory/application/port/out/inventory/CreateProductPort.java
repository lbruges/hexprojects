package galaxy.hexagonal.arch.inventory.application.port.out.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;

public interface CreateProductPort {

    void createProduct(VehicleProduct product);

}
