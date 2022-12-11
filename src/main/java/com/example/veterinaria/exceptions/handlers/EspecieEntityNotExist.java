package com.example.veterinaria.exceptions.handlers;

public class EspecieEntityNotExist extends NotFoundException{
    private static final String DESCRIPTION = "Entidad no encontrada";
    public EspecieEntityNotExist(String detail){
        super(DESCRIPTION +". "+detail);
    }
}
