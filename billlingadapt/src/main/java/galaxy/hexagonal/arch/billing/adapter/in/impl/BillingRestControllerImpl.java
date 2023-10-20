package galaxy.hexagonal.arch.billing.adapter.in.impl;

import galaxy.hexagonal.arch.billing.adapter.in.BillingRestController;
import galaxy.hexagonal.arch.billing.adapter.in.util.BaseRestController;
import galaxy.hexagonal.arch.billing.application.service.BillingService;
import galaxy.hexagonal.arch.domain.rental.ReturnedVehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static galaxy.hexagonal.arch.billing.adapter.in.util.Constants.Routes.BILLING;

@RequestMapping(path = BILLING)
@Controller
@RequiredArgsConstructor
public class BillingRestControllerImpl extends BaseRestController implements BillingRestController {

    private final BillingService billingService;

    @Override
    public ResponseEntity<?> generateBill(ReturnedVehicle rentedVehicle) {
        try {
            return ofSuccess(billingService.generateBill(rentedVehicle));
        } catch (Exception e) {
            return ofError(e);
        }
    }

    @Override
    public ResponseEntity<?> getAllBills() {
        try {
            return ofSuccess(billingService.getAllBills());
        } catch (Exception e) {
            return ofError(e);
        }
    }
}
