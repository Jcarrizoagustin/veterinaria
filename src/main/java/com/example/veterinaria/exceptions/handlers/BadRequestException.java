package com.example.veterinaria.exceptions.handlers;

public class BadRequestException extends RuntimeException{
    private static final String DESCRIPTION = "Bad Request Exception (400)";

    public BadRequestException(String detail){
        super(DESCRIPTION + ". " +detail);
    }
}
