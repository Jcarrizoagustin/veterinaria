package com.example.veterinaria.dtos.especie;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor @NoArgsConstructor
public class EspecieDTO {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

}
