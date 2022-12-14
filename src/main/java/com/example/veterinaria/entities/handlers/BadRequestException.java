package com.example.veterinaria.entities.handlers;

public class BadRequestException extends RuntimeException{
    private static final String DESCRIPTION = "Bad Request Exception (400)";

    public BadRequestException(String detail){
        super(DESCRIPTION + ". " +detail);
    }
}
