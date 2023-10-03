package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.adapter.out.InventoryAdapter;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddProductUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddVehicleUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.GetAllProductsUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InventoryService implements AddProductUseCase, AddVehicleUseCase, GetAllProductsUseCase {

    private final InventoryAdapter adapter;

    @Override
    public void addProductToCatalog(VehicleProduct product) {

        if (!adapter.modelPresent(product.model())) {
            adapter.createModel(product.model());
        }

        adapter.createProduct(product);
    }

    @Override
    public void addVehicleToCatalog(InventoryVehicleItem vehicleItem) {
        adapter.addVehicle(vehicleItem);
    }

    @Override
    public List<VehicleProduct> getAllProducts() {
        return adapter.getAllProducts();
    }
}
