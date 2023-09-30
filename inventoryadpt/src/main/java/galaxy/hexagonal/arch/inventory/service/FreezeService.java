package galaxy.hexagonal.arch.inventory.service;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.Vehicle;
import galaxy.hexagonal.arch.domain.inventory.FrozenInventory;
import galaxy.hexagonal.arch.inventory.exception.InventoryException;
import galaxy.hexagonal.arch.port.in.freeze.FreezeRentalUseCase;
import galaxy.hexagonal.arch.port.in.freeze.GetFreezeUseCase;

public class FreezeService implements FreezeRentalUseCase, GetFreezeUseCase {
    @Override
    public FrozenInventory freezeRental(Vehicle vehicle, RentalPeriod rentalPeriod) throws InventoryException {
        return null;
    }

    @Override
    public FrozenInventory getFreeze(String freezeCode) {
        return null;
    }
}
