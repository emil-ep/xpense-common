package org.xperia.exception;

public class TrackerUnknownException extends TrackerException{

    public TrackerUnknownException(String message) {
        super(message, 500);
    }

    public TrackerUnknownException(String message, Throwable cause){
        super(message, 500, cause);
    }
}
