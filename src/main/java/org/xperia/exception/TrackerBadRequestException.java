package org.xperia.exception;

public class TrackerBadRequestException extends TrackerException{

    public TrackerBadRequestException(String message){
        super(message, 400);
    }

    public TrackerBadRequestException(String message, Throwable cause){
        super(message, 400, cause);
    }
}
