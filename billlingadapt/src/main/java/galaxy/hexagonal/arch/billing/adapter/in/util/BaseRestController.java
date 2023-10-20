package galaxy.hexagonal.arch.billing.adapter.in.util;

import galaxy.hexagonal.arch.billing.adapter.in.model.ErrorResponse;
import galaxy.hexagonal.arch.billing.application.exception.BillingException;
import galaxy.hexagonal.arch.exception.BaseException;
import galaxy.hexagonal.arch.exception.ErrorType;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static galaxy.hexagonal.arch.billing.adapter.in.util.Constants.Errors.APPLICATION_EXCEPTION;
import static galaxy.hexagonal.arch.billing.adapter.in.util.Constants.Errors.BILLING_ERROR;

public abstract class BaseRestController {

    protected ResponseEntity<?> ofSuccess(Object entity) {
        return new ResponseEntity<>(entity, HttpStatusCode.valueOf(200));
    }

    protected ResponseEntity<ErrorResponse> ofError(Throwable t) {
        ErrorType errorType;
        String details;

        switch (t) {
            case BillingException be -> {
                errorType = be.getErrorType();
                details = BILLING_ERROR;
            }
            case BaseException be -> {
                errorType = be.getErrorType();
                details = APPLICATION_EXCEPTION;
            }
            default -> {
                errorType = ErrorType.UNEXPECTED;
                details = t.getClass().getCanonicalName();
            }
        }

        return getErrorResponseFromErrorType(errorType, details);
    }

    protected ResponseEntity<?> ofCreated() {
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
    protected ResponseEntity<?> ofNoContent() {
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    private ResponseEntity<ErrorResponse> getErrorResponseFromErrorType(ErrorType errorType, String details) {

        var errorResponse = ErrorResponse.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .details(details)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(errorType.getHttpErrorCode()));
    }

}
