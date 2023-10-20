package galaxy.hexagonal.arch.inventory.adapter.out.rest;

import galaxy.hexagonal.arch.domain.billing.Bill;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;
import galaxy.hexagonal.arch.inventory.adapter.out.rest.client.BillingClient;
import galaxy.hexagonal.arch.inventory.application.port.out.billing.GenericBillingPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class BillingClientAdapter extends GenericBillingPort {

    private final BillingClient billingClient;

    @Override
    public void reportToBilling(ReturnedVehicle returnedVehicle) {
        Bill bill = billingClient.generateBill(returnedVehicle);
        log.info("Generated bill: {}", bill);
    }
}
