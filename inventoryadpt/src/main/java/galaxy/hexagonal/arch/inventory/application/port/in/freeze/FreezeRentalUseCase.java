package galaxy.hexagonal.arch.inventory.application.port.in.freeze;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.inventory.Vehicle;
import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;

public interface FreezeRentalUseCase {
    FrozenInventory freezeRental(Vehicle vehicle, RentalPeriod rentalPeriod) throws InventoryException;

}
