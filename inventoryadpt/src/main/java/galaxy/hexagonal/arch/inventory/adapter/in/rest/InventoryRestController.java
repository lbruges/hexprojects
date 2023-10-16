package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import galaxy.hexagonal.arch.domain.inventory.req.InventoryVehicleItem;
import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.INVENTORY_VEHICLE_PATH;

public interface InventoryRestController {
    @GetMapping
    ResponseEntity<?> getAllProducts();

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody VehicleProduct vehicleProduct);

    @PostMapping(path = INVENTORY_VEHICLE_PATH)
    ResponseEntity<?> createVehicle(@RequestBody InventoryVehicleItem vehicleItem);

}
