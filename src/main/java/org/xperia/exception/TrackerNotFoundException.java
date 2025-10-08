package org.xperia.exception;

public class TrackerNotFoundException extends TrackerException{

    public TrackerNotFoundException(String message){
        super(message, 404);
    }

    public TrackerNotFoundException(String message, Throwable cause){
        super(message, 404, cause);
    }
}
