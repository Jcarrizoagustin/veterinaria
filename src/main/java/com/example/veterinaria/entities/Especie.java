package com.example.veterinaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "especie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie")
    @Getter @Setter
    private Long id;

    @Column(name = "nombre",unique = true)
    @Getter @Setter
    private String nombre;


}
