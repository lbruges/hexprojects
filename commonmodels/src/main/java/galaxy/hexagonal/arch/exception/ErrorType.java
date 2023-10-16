package galaxy.hexagonal.arch.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
    UNEXPECTED("000", "Unknown cause", 500),

    //Inventory errors.
    RAN_OUT_OF_INVENTORY("101", "No units available for rental.", 400),
    INVALID_PRODUCT("102", "The product is invalid. Please try again.", 400),
    PRODUCT_NOT_FOUND("103", "The product was not found, unable to proceed.", 404),
    EMPTY_CATALOG("104", "No vehicles available to offer.", 404),
    FAILED_TO_FREEZE("105", "Failed to perform freeze. Please try again." , 500),
    FREEZE_NOT_FOUND("106", "Freeze not found." , 404),
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
