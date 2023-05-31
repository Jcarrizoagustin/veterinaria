package com.example.veterinaria.exceptions.handlers;

public class MascotaNotExistException extends NotFoundException{
    private static final String DESCRIPTION = "Mascota not exist";
    public MascotaNotExistException(String detail){
        super(DESCRIPTION +". " + detail);
    }
}
