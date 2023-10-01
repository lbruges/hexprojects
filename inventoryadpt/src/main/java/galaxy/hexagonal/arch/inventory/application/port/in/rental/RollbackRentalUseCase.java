package galaxy.hexagonal.arch.inventory.application.port.in.rental;

import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;

public interface RollbackRentalUseCase {
    void rollbackRental(String freezeCode) throws InventoryException;

}
