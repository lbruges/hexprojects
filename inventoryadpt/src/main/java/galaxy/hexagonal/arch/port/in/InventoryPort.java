package galaxy.hexagonal.arch.port.in;

import galaxy.hexagonal.arch.domain.RentalPeriod;
import galaxy.hexagonal.arch.domain.Vehicle;
import galaxy.hexagonal.arch.domain.inventory.FrozenInventory;
import galaxy.hexagonal.arch.domain.rental.RentedVehicle;
import galaxy.hexagonal.arch.inventory.exception.InventoryException;

public interface InventoryPort {
    FrozenInventory freezeRental(Vehicle vehicle, RentalPeriod rentalPeriod) throws InventoryException;
    FrozenInventory getFreeze(String freezeCode);
    RentedVehicle updateInventory(FrozenInventory frozenInventory);
    void rollbackFreeze(String freezeCode) throws InventoryException;
}
