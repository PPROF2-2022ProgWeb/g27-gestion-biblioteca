package com.grupo27.library.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.logging.Logger;


@ControllerAdvice
@RestController
@EnableWebMvc
public class GlobalExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allError(Exception ex, WebRequest req){

        LOGGER.info(ex.getMessage());
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
