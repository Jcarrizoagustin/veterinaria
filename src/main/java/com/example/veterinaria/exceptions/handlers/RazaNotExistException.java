package com.example.veterinaria.exceptions.handlers;

public class RazaNotExistException extends NotFoundException{
    private static final String DESCRIPTION = "Raza no existe";
    public RazaNotExistException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}
