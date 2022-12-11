package com.example.veterinaria.exceptions.handlers;

public class EntityNotExistException extends RuntimeException{
    public EntityNotExistException(String msg){
        super(msg);
    }
}
