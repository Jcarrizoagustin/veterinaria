package com.example.veterinaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "raza")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name ="id_raza")
    private Long id;

    @Column(name = "nombre",unique = true)
    @Getter @Setter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_especie", referencedColumnName = "id_especie")
    @Getter @Setter
    private Especie especie;
}
