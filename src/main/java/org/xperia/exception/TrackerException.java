package org.xperia.exception;

public class TrackerException extends RuntimeException{

    private int httpStatus;

    public TrackerException(String message, int httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }

    public TrackerException(String message, int httpStatus, Throwable cause){
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
