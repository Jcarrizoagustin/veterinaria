package com.example.veterinaria.services;

import com.example.veterinaria.entities.Turno;
import com.example.veterinaria.entities.handlers.ConflictException;
import com.example.veterinaria.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository repository;

    public List<Turno> todosLosTurnos(){
        return repository.findAll();
    }

    public Turno guardarTurno(Turno turno){
        LocalDate dia = turno.getFecha();
        LocalTime hora =turno.getHora();
        if(existeTurno(dia,hora)){
            throw new ConflictException("Ya existe turno para este dia. Dia: " + dia.toString() + ", Hora: "+hora.toString());
        }
        return repository.save(turno);
    }

    public List<Turno> turnosDelDia(LocalDate date){
        return repository.findAllByFecha(date);
    }

    public boolean existeTurno(LocalDate fecha,LocalTime hora){
        return repository.existsTurnoByFechaAndHora(fecha,hora);
    }

}
