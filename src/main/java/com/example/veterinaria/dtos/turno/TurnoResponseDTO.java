package com.example.veterinaria.dtos.turno;

import lombok.Data;

@Data
public class TurnoResponseDTO {

    private Long id;
    private String fecha;
    private String hora;
    private String especieMascota;
    private String razaMascota;
    private String nombreMascota;

}
