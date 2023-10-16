package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import galaxy.hexagonal.arch.domain.Period;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CatalogRestController {

    @GetMapping
    ResponseEntity<?> getCatalog(@RequestBody Period rentalPeriod);
}
