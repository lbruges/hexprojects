package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public interface CatalogRestController {

    @GetMapping
    ResponseEntity<?> getCatalog(@RequestParam("startDate") LocalDate startDate, @RequestParam("dayCount") int dayCount);
}
