package galaxy.hexagonal.arch.inventory.application.port.in.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;

import java.util.List;

public interface GetAllProductsUseCase {

    List<VehicleProduct> getAllProducts();

}
