package com.example.veterinaria.dtos.propietario;

import lombok.Data;

@Data
public class PropietarioResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;


}
