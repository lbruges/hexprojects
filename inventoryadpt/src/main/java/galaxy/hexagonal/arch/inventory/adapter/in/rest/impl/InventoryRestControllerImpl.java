package galaxy.hexagonal.arch.inventory.adapter.in.rest.impl;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProductRequest;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.InventoryRestController;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.util.BaseRestController;
import galaxy.hexagonal.arch.inventory.application.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.INVENTORY_PATH;

@Controller
@RequestMapping(path=INVENTORY_PATH)
@RequiredArgsConstructor
public class InventoryRestControllerImpl extends BaseRestController implements InventoryRestController {

    private final InventoryService inventoryService;

    @Override
    public ResponseEntity<?> createModel(VehicleModel model) {
        try {
            inventoryService.createModel(model);
            return ofCreated();
        } catch (Exception e) {
            return ofError(e);
        }
    }

    @Override
    public ResponseEntity<?> getAllModels() {
        try {
            return ofSuccess(inventoryService.getAllModels());
        } catch (Exception e) {
            return ofError(e);
        }
    }

    public ResponseEntity<?> getAllProducts() {
        try {
            return ofSuccess(inventoryService.getAllProducts());
        } catch (Exception e) {
            return ofError(e);
        }
    }

    public ResponseEntity<?> createProduct(VehicleProductRequest vehicleProduct) {
        try {
            inventoryService.addProductToCatalog(vehicleProduct);
            return ofCreated();
        } catch (Exception e) {
            return ofError(e);
        }

    }

    public ResponseEntity<?> createVehicle(@RequestBody InventoryVehicleItem vehicleItem) {
        try {
            inventoryService.addVehicleToCatalog(vehicleItem);
            return ofCreated();
        } catch (Exception e) {
            return ofError(e);
        }
    }
}
