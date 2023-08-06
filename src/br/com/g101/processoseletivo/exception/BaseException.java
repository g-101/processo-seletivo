package br.com.g101.processoseletivo.exception;

public abstract class BaseException extends Exception {

    private String errorMessage;

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
