package com.example.veterinaria.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id_ticket")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Turno turno;
}
