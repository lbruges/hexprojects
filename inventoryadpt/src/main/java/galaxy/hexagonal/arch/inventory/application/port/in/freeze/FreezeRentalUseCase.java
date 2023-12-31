package galaxy.hexagonal.arch.inventory.application.port.in.freeze;

import galaxy.hexagonal.arch.domain.util.Period;
import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;

public interface FreezeRentalUseCase {
    FrozenInventory freezeRental(String sku, Period freezePeriod) throws InventoryException;

}
