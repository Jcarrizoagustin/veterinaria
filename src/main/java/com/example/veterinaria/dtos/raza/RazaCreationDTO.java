package com.example.veterinaria.dtos.raza;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
public class RazaCreationDTO {
    @NotBlank
    @Getter @Setter
    private String nombre;
    @NotNull
    @Getter @Setter
    private Long idEspecie;

}
