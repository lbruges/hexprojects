package galaxy.hexagonal.arch.exception;

import lombok.Data;

@Data
public abstract class BaseException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE_FORMAT = "Error code: %s. Message: %s.";
    private final ErrorType errorType;
    public BaseException(ErrorType errorType) {
        super(getFormattedErrorMessage(errorType));
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, Throwable cause) {
        super(getFormattedErrorMessage(errorType), cause);
        this.errorType = errorType;
    }

    public int getHttpErrorCode() {
        return errorType.getHttpErrorCode();
    }

    private static String getFormattedErrorMessage(ErrorType errorType) {
        return String.format(EXCEPTION_MESSAGE_FORMAT, errorType.getCode(), errorType.getMessage());
    }

}
