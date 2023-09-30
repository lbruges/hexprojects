package galaxy.hexagonal.arch.port.in.rental;

import galaxy.hexagonal.arch.inventory.exception.InventoryException;

public interface RollbackRentalUseCase {
    void rollbackRental(String freezeCode) throws InventoryException;

}
