package com.example.veterinaria.dtos.propietario;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PropietarioCreationDTO {

    @NotBlank(message = "nombre is required")
    private String nombre;
    @NotBlank(message = "apellido is required")
    private String apellido;
    @NotBlank(message = "telefono is required")
    private String telefono;
    @NotBlank(message = "direccion is required")
    private String direccion;
}
