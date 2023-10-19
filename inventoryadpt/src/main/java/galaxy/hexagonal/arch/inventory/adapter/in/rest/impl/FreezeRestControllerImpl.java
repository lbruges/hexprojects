package galaxy.hexagonal.arch.inventory.adapter.in.rest.impl;

import galaxy.hexagonal.arch.domain.util.Duration;
import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.FreezeRestController;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.FreezeCommand;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.util.BaseRestController;
import galaxy.hexagonal.arch.inventory.application.service.FreezeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Routes.FREEZE_PATH;

@Controller
@RequestMapping(path = FREEZE_PATH)
@RequiredArgsConstructor
public class FreezeRestControllerImpl extends BaseRestController implements FreezeRestController {

    private final FreezeService freezeService;

    @Override
    public ResponseEntity<?> freezeRental(FreezeCommand command) {
        try {
            Period freezePeriod = Period.builder()
                    .startDate(LocalDate.now())
                    .startTime(LocalTime.now())
                    .duration(new Duration(command.freezeDurationInMins(), ChronoUnit.MINUTES))
                    .build();

            return ofSuccess(freezeService.freezeRental(command.sku(), freezePeriod));
        } catch (Exception e) {
            return ofError(e);
        }
    }

    @Override
    public ResponseEntity<?> getFreeze(String freezeCode) {
        try {
            return ofSuccess(freezeService.getFreeze(freezeCode));
        } catch (Exception e) {
            return ofError(e);
        }
    }

    @Override
    public ResponseEntity<?> rollbackFreeze(String freezeCode) {
        try {
            freezeService.rollbackFreeze(freezeCode);
            return ofNoContent();
        } catch (Exception e) {
            return ofError(e);
        }
    }
}
