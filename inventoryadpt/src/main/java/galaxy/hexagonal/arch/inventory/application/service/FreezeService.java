package galaxy.hexagonal.arch.inventory.application.service;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.inventory.Vehicle;
import galaxy.hexagonal.arch.domain.inventory.resp.FrozenInventory;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.FreezeRentalUseCase;
import galaxy.hexagonal.arch.inventory.application.port.in.freeze.GetFreezeUseCase;

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
