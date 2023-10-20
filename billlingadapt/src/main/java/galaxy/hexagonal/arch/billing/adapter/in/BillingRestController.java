package galaxy.hexagonal.arch.billing.adapter.in;

import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BillingRestController {

    @PostMapping
    ResponseEntity<?> generateBill(@RequestBody RentedVehicle rentedVehicle);
    @GetMapping
    ResponseEntity<?> getAllBills();

}
