package com.example.veterinaria.dtos.especie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
public class EspecieCreationDTO {
    @Getter @Setter
    @NotNull(message = "nombre is required") @NotBlank(message = "nombre is required")
    private String nombre;

}
