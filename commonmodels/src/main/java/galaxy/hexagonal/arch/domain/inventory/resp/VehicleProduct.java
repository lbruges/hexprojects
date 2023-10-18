package galaxy.hexagonal.arch.domain.inventory.resp;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;

public record VehicleProduct(String sku, float price, VehicleModel model) {
}
