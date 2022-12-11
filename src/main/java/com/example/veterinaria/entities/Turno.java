package com.example.veterinaria.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    @Getter @Setter
    private Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @Getter @Setter
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "fk_mascota",referencedColumnName = "id_mascota")
    @Getter @Setter
    private Mascota mascota;

}
