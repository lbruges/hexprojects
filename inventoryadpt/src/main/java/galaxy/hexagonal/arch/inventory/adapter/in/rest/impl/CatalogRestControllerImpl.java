package galaxy.hexagonal.arch.inventory.adapter.in.rest.impl;

import galaxy.hexagonal.arch.domain.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.CatalogRestController;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.util.BaseRestController;
import galaxy.hexagonal.arch.inventory.application.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.CATALOG_PATH;

@Controller
@RequestMapping(path = CATALOG_PATH)
@RequiredArgsConstructor
public class CatalogRestControllerImpl extends BaseRestController implements CatalogRestController {

    private final CatalogService catalogService;

    public ResponseEntity<?> getCatalog(Period rentalPeriod) {
        try {
            List<VehicleItem> vehicleItems = catalogService.getRentableVehicles(rentalPeriod);
            return ofSuccess(vehicleItems);
        } catch (Exception e) {
            return ofError(e);
        }
    }

}
