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
    UNABLE_TO_THAW("107", "Could not release the inventory for the freeze. Please retry later." , 500),
    RENT_FREEZE_MISMATCH("108", "Could not complete rental because of a freeze code mismatch. Please " +
            "provide a valid freeze code", 400),
    UNABLE_TO_COMPLETE_RENT("109", "Could not complete rent. Please try again.",503),
    RENTER_VEHICLE_MISMATCH("110", "Specified vehicle and renter information do not match. Please review " +
            "the input data and try again.", 400),
    UNABLE_TO_RETURN_VEHICLE("111", "Unable to return the vehicle, please review your input data and try " +
            "again.", 500),

    //Accounting errors.
    RENTAL_ACCOUNTING_ERROR("201", "Error while accounting rental.", 500),
    RENTAL_BILL_ERROR("202", "Error while generation bill. Please review the input data.", 400),

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
