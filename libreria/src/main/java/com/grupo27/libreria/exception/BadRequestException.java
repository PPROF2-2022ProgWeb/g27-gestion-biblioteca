package com.grupo27.libreria.exception;


public class BadRequestException extends Exception {
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}