package com.grupo27.library.exception;


public class BadRequestException extends Exception {
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}