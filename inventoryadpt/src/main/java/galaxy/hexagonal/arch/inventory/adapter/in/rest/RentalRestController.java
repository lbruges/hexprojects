package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.FinalizeRentalCommand;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.ReturnVehicleCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface RentalRestController {

    @PostMapping
    ResponseEntity<?> finalizeRental(@RequestBody FinalizeRentalCommand command);

    @PatchMapping
    ResponseEntity<?> returnVehicle(@RequestBody ReturnVehicleCommand command);

}
