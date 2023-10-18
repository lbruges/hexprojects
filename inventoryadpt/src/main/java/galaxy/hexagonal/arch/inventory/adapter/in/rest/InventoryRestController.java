package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleModel;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.INVENTORY_MODEL_PATH;
import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.INVENTORY_VEHICLE_PATH;

public interface InventoryRestController {

    @PostMapping(path = INVENTORY_MODEL_PATH)
    ResponseEntity<?> createModel(@RequestBody VehicleModel model);

    @GetMapping(path = INVENTORY_MODEL_PATH)
    ResponseEntity<?> getAllModels();

    @GetMapping
    ResponseEntity<?> getAllProducts();

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody VehicleProductRequest vehicleProduct);

    @PostMapping(path = INVENTORY_VEHICLE_PATH)
    ResponseEntity<?> createVehicle(@RequestBody InventoryVehicleItem vehicleItem);

}
