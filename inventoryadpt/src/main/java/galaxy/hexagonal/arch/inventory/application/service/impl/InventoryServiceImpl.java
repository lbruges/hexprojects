package galaxy.hexagonal.arch.inventory.application.service.impl;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.domain.inventory.resp.VehicleProduct;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProductRequest;
import galaxy.hexagonal.arch.inventory.application.port.out.inventory.GenericInventoryPort;
import galaxy.hexagonal.arch.inventory.application.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl extends InventoryService {

    private final GenericInventoryPort adapter;

    @Override
    public void createModel(VehicleModel model) {
        adapter.createModel(model);
    }

    @Override
    public List<VehicleModel> getAllModels() {
        return adapter.getAllModels();
    }

    @Override
    public void addProductToCatalog(VehicleProductRequest product) {
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
