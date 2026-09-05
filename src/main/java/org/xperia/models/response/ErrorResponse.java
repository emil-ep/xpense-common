package org.xperia.models.response;

public class ErrorResponse<T> extends AbstractResponse<T>{

    public ErrorResponse(T data){
        this.status = 0;
        this.data = data;
    }
}
