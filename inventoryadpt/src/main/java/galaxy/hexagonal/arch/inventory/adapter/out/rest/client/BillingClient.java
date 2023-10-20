package galaxy.hexagonal.arch.inventory.adapter.out.rest.client;

import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "billing", url = "${inv.port.billing.url}")
public interface BillingClient {

    @PostMapping("/billing")
    Bill generateBill(@RequestBody ReturnedVehicle returnedVehicle);

}
