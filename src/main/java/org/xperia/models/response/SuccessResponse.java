package org.xperia.models.response;

public class SuccessResponse<T> extends AbstractResponse<T>{

    public SuccessResponse(){

    }
    public SuccessResponse(T data) {
        this.status = 1;
        this.data = data;
    }
}
