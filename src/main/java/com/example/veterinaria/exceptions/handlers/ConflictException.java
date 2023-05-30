package com.example.veterinaria.entities.handlers;

public class ConflictException extends RuntimeException{
    private static final String DESCRIPTION = "Conflict exception (409)";

    public ConflictException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}
