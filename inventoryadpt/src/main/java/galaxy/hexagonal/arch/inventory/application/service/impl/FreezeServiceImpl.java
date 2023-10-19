package galaxy.hexagonal.arch.inventory.application.service.impl;

import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.out.freeze.GenericFreezePort;
import galaxy.hexagonal.arch.inventory.application.service.FreezeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreezeServiceImpl extends FreezeService {

    private final GenericFreezePort freezePort;

    @Override
    public FrozenInventory freezeRental(String sku, Period freezePeriod) throws InventoryException {
        return freezePort.freezeVehicle(sku, freezePeriod.getDuration().toMinutesPart(),
                freezePeriod.getStartDateTime());
    }

    @Override
    public FrozenInventory getFreeze(String freezeCode) {
        return freezePort.getFreeze(freezeCode);
    }

    @Override
    public void rollbackFreeze(String freezeCode) throws InventoryException {
        freezePort.thawVehicle(freezeCode);
    }
}
