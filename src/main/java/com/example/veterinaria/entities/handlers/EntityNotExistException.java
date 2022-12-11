package com.example.veterinaria.entities.handlers;

public class EntityNotExistException extends RuntimeException{
    public EntityNotExistException(String msg){
        super(msg);
    }
}
