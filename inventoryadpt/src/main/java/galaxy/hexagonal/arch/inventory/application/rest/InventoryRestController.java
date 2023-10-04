package galaxy.hexagonal.arch.inventory.application.rest;

import galaxy.hexagonal.arch.domain.inventory.req.VehicleProduct;
import galaxy.hexagonal.arch.inventory.application.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/products")
@RequiredArgsConstructor
public class InventoryRestController {

    final InventoryService inventoryService;

    @GetMapping
    public @ResponseBody List<VehicleProduct> getAllProducts() {
        return inventoryService.getAllProducts();
    }

    @PostMapping
    public @ResponseBody boolean createProduct(@RequestBody VehicleProduct vehicleProduct) {
        inventoryService.addProductToCatalog(vehicleProduct);
        return true;
    }

}
