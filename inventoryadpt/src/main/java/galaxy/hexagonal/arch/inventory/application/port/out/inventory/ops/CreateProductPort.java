package galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;

public interface CreateProductPort {

    void createProduct(VehicleProduct product);

}
