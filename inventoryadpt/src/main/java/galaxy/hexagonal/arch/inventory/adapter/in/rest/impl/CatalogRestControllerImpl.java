package galaxy.hexagonal.arch.inventory.adapter.in.rest.impl;

import galaxy.hexagonal.arch.domain.util.Duration;
import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.VehicleItem;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.CatalogRestController;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.util.BaseRestController;
import galaxy.hexagonal.arch.inventory.application.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.CATALOG_PATH;

@Controller
@RequestMapping(path = CATALOG_PATH)
@RequiredArgsConstructor
public class CatalogRestControllerImpl extends BaseRestController implements CatalogRestController {
    @Value("${inv.port.avail.start.rental.time:09:00}")
    private String rentalStartTime;

    private final CatalogService catalogService;

    public ResponseEntity<?> getCatalog(LocalDate startDate, int dayCount) {
        try {
            Period rentalPeriod = Period.builder()
                    .startDate(startDate)
                    .startTime(LocalTime.parse(rentalStartTime))
                    .duration(new Duration(dayCount, ChronoUnit.DAYS))
                    .build();
            List<VehicleItem> vehicleItems = catalogService.getRentableVehicles(rentalPeriod);
            return ofSuccess(vehicleItems);
        } catch (Exception e) {
            return ofError(e);
        }
    }

}
