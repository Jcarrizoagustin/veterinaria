package com.example.veterinaria.dtos.mascota;

import lombok.Data;

@Data
public class MascotaResponseDTO {
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String propietario;
}
