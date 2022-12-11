package com.example.veterinaria.dtos.mascota;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class MascotaCreationDTO {

    @NotBlank
    private String nombre;
    @NotNull
    private Long idPropietario;
    @NotNull
    private Long idRaza;

}
