package com.example.veterinaria.services;

import com.example.veterinaria.entities.Turno;
import com.example.veterinaria.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository repository;

    public List<Turno> todosLosTurnos(){
        return repository.findAll();
    }

    public Turno guardarTurno(Turno turno){
        return repository.save(turno);
    }

    public List<Turno> turnosDelDia(LocalDateTime date){
        return repository.findAllByFecha(date);
    }
}
