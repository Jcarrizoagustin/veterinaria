package com.example.veterinaria.repositories;

import com.example.veterinaria.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {
    List<Turno> findAllByFecha(LocalDate fecha);

    boolean existsTurnoByFechaAndHora(LocalDate fecha,LocalTime hora);

}
