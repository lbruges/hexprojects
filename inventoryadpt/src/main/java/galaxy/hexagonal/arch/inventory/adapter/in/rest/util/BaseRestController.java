package galaxy.hexagonal.arch.inventory.adapter.in.rest.util;

import galaxy.hexagonal.arch.exception.BaseException;
import galaxy.hexagonal.arch.exception.ErrorType;
import galaxy.hexagonal.arch.inventory.adapter.in.rest.model.ErrorResponse;
import galaxy.hexagonal.arch.inventory.application.exception.InventoryException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Errors.APPLICATION_EXCEPTION;
import static galaxy.hexagonal.arch.inventory.adapter.in.rest.util.Constants.Errors.INVENTORY_EXCEPTION;

public abstract class BaseRestController {

    protected ResponseEntity<?> ofSuccess(Object entity) {
        return new ResponseEntity<>(entity, HttpStatusCode.valueOf(200));
    }

    protected ResponseEntity<ErrorResponse> ofError(Throwable t) {
        ErrorType errorType;
        String details;

        switch (t) {
            case InventoryException ie -> {
                errorType = ie.getErrorType();
                details = INVENTORY_EXCEPTION;
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
