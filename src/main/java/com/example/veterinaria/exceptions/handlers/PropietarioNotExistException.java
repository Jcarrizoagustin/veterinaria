package com.example.veterinaria.exceptions.handlers;

public class PropietarioNotExistException extends NotFoundException{
    private static final String DESCRIPTION = "El usuario no se encuntra registrado";

    public PropietarioNotExistException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}
