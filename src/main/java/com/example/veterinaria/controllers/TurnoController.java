package com.example.veterinaria.controllers;

import com.example.veterinaria.dtos.turno.TurnoCreationDTO;
import com.example.veterinaria.dtos.turno.TurnoResponseDTO;
import com.example.veterinaria.entities.Turno;
import com.example.veterinaria.exceptions.handlers.NotFoundException;
import com.example.veterinaria.mappers.TurnoMapper;
import com.example.veterinaria.services.TurnoService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
    @Autowired
    private TurnoMapper mapper;
    @Autowired
    private TurnoService service;

    @PostMapping
    public ResponseEntity<TurnoResponseDTO> guardarTurno(@Valid @RequestBody TurnoCreationDTO turnoCreationDTO){
        Turno turno = mapper.turnoCreationDTOToTurno(turnoCreationDTO);
        Turno creado = service.guardarTurno(turno);
        return ResponseEntity.ok(mapper.turnoToTurnoResponseDTO(creado));
    }

    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> todosLosTurnos(){
        List<Turno> turnos = service.todosLosTurnos();
        return ResponseEntity.ok(mapper.turnoToTurnoResponseDTOList(turnos));
    }

    @GetMapping("/dia")
    public ResponseEntity<List<TurnoResponseDTO>> turnosDelDia(@RequestParam(value = "fecha") @DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE) LocalDate dia){
        LocalDateTime diaF = LocalDateTime.of(dia, LocalTime.of(17,55));
        List<Turno> turnosList = service.turnosDelDia(diaF);
        if(turnosList.isEmpty()){
            throw new NotFoundException("No existen turnos para: " + dia.toString());
        }
        return ResponseEntity.ok(mapper.turnoToTurnoResponseDTOList(turnosList));
    }
}
