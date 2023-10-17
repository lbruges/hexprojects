package galaxy.hexagonal.arch.inventory.application.port.in.freeze;

import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;

public interface RollbackFreezeUseCase {
    void rollbackFreeze(String freezeCode) throws InventoryException;

}
