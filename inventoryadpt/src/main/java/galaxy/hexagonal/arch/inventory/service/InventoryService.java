package galaxy.hexagonal.arch.inventory.service;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.Vehicle;
import galaxy.hexagonal.arch.domain.inventory.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.exception.InventoryException;
import galaxy.hexagonal.arch.port.in.InventoryPort;

public class InventoryService implements InventoryPort {
    @Override
    public FrozenInventory freezeRental(Vehicle vehicle, RentalPeriod rentalPeriod) throws InventoryException {
        return null;
    }

    @Override
    public FrozenInventory getFreeze(String freezeCode) {
        return null;
    }

    @Override
    public RentedVehicle updateInventory(FrozenInventory frozenInventory) {
        return null;
    }

    @Override
    public void rollbackFreeze(String freezeCode) throws InventoryException {

    }
}
