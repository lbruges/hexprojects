package galaxy.hexagonal.arch.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    //Inventory errors.
    RUN_OUT_OF_INVENTORY("101", "No units available for rental.", 400),
    INVALID_PRODUCT("102", "The product is invalid. Please try again.", 400),
    PRODUCT_NOT_FOUND("103", "The product was not found, unable to proceed.", 404),
    //Accounting errors.
    RENTAL_ACCOUNTING_ERROR("201", "Error while accounting rental.", 500),
    //Calendar errors.
    INVALID_DATE_RANGE("301", "Invalid date range.", 400);

    private final String code;
    private final String message;
    private final int httpErrorCode;
    ErrorType(String code, String message, int httpErrorCode) {
        this.code = code;
        this.message = message;
        this.httpErrorCode = httpErrorCode;
    }
}
