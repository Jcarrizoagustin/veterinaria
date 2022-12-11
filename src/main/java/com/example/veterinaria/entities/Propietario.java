package com.example.veterinaria.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "propietario")
@NoArgsConstructor @AllArgsConstructor
public class Propietario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_propietario")
   @Getter @Setter
   private Long id;

   @Column(name = "nombre")
   @Getter @Setter
   private String nombre;

   @Column(name = "apellido")
   @Getter @Setter
   private String apellido;

   @Column(name = "telefono",unique = true)
   @Getter @Setter
   private String telefono;

   @Column(name = "direccion")
   @Getter @Setter
   private String direccion;
}
