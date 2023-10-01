package galaxy.hexagonal.arch.inventory.application.exception;

import galaxy.hexagonal.arch.exception.BaseException;
import galaxy.hexagonal.arch.exception.ErrorType;

public class InventoryException extends BaseException {
    public InventoryException(ErrorType errorType) {
        super(errorType);
    }

    public InventoryException(ErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }
}