package com.example.veterinaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mascota")
@AllArgsConstructor @NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    @Getter @Setter
    private Long id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_raza", referencedColumnName = "id_raza")
    @Getter @Setter
    @NotNull(message = "Raza is required")
    private Raza raza;

    @ManyToOne
    @JoinColumn(name = "fk_propietario", referencedColumnName = "id_propietario")
    @Getter @Setter
    @NotNull(message = "Propietario is required")
    private Propietario propietario;

}
