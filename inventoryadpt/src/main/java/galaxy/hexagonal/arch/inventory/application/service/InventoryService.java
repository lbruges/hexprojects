package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.GenericInventoryPort;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddProductUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.AddVehicleUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.inventory.GetAllProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements AddProductUseCase, AddVehicleUseCase, GetAllProductsUseCase {

    private final GenericInventoryPort adapter;

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
