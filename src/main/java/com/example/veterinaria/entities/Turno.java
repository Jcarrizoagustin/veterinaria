package com.example.veterinaria.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    @Getter @Setter
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @Getter @Setter
    private LocalDate fecha;

    @DateTimeFormat(pattern = "HH:mm",iso = DateTimeFormat.ISO.TIME)
    @Getter @Setter
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "fk_mascota",referencedColumnName = "id_mascota")
    @Getter @Setter
    private Mascota mascota;

}
