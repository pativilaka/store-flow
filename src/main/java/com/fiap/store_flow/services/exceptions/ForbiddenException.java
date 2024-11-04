package com.fiap.store_flow.services.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String msg){
        super(msg);
    }
}
