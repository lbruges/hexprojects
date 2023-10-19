package galaxy.hexagonal.arch.inventory.adapter.in.rest;

import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.FreezeCommand;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.FREEZE_ID_PATH;

public interface FreezeRestController {

    @PostMapping
    ResponseEntity<?> freezeRental(@RequestBody FreezeCommand command);

    @GetMapping(path = FREEZE_ID_PATH)
    ResponseEntity<?> getFreeze(@PathParam("freezeCode") String freezeCode);

    @DeleteMapping(path = FREEZE_ID_PATH)
    ResponseEntity<?> rollbackFreeze(@PathParam("freezeCode") String freezeCode);

}
