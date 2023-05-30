package com.example.veterinaria.entities.handlers;

public class EspecieEntityNotExist extends NotFoundException{
    private static final String DESCRIPTION = "Entidad no encontrada";
    public EspecieEntityNotExist(String detail){
        super(DESCRIPTION +". "+detail);
    }
}
