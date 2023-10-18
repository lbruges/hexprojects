package galaxy.hexagonal.arch.inventory.application.port.out.inventory.ops;

import galaxy.hexagonal.arch.domain.inventory.resp.VehicleProduct;

import java.util.List;

public interface GetAllProductsPort {
    List<VehicleProduct> getAllProducts();

}
