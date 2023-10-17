package galaxy.hexagonal.arch.inventory.adapter.in.rest.impl;

import galaxy.hexagonal.arch.inventory.adapter.in.rest.RentalRestController;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.FinalizeRentalCommand;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.ReturnVehicleCommand;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.util.BaseRestController;
import galaxy.hexagonal.arch.inventory.application.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.RENTAL_PATH;

@Controller
@RequestMapping(path = RENTAL_PATH)
@RequiredArgsConstructor
public class RentalRestControllerImpl extends BaseRestController implements RentalRestController {
    private RentalService rentalService;

    @Override
    public ResponseEntity<?> finalizeRental(FinalizeRentalCommand command) {
        try {
            return ofSuccess(rentalService.finalizeRental(command.freezeCode(), command.renter(), command.rentalPeriod()));
        } catch (Exception e) {
            return ofError(e);
        }
    }

    @Override
    public ResponseEntity<?> returnVehicle(ReturnVehicleCommand command) {
        try {
            rentalService.returnVehicle(command.plate(), command.renter());
            return ofNoContent();
        } catch (Exception e) {
            return ofError(e);
        }
    }
}
