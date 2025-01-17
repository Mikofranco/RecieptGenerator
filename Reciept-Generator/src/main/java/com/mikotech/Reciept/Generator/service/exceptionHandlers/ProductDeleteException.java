package com.mikotech.Reciept.Generator.service.exceptionHandlers;

public class ProductDeleteException extends RuntimeException {
    public ProductDeleteException(String message) {
        super(message);
    }
}
