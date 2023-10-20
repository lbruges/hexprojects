package galaxy.hexagonal.arch.billing.application.exception;

import galaxy.hexagonal.arch.exception.BaseException;
import galaxy.hexagonal.arch.exception.ErrorType;

public class BillingException extends BaseException {
    public BillingException(ErrorType errorType) {
        super(errorType);
    }

    public BillingException(ErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }
}
