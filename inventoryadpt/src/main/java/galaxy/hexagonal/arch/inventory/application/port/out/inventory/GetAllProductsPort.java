package galaxy.hexagonal.arch.inventory.application.port.out.inventory;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;

import java.util.List;

public interface GetAllProductsPort {
    List<VehicleProduct> getAllProducts();

}
