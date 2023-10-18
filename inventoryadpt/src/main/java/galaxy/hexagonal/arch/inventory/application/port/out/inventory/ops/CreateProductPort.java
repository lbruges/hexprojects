package galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProductRequest;

public interface CreateProductPort {

    void createProduct(VehicleProductRequest product);

}
