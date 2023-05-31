package com.example.veterinaria.controllers;

import com.example.veterinaria.dtos.raza.RazaCreationDTO;
import com.example.veterinaria.dtos.raza.RazaResponseDTO;
import com.example.veterinaria.entities.Raza;
import com.example.veterinaria.exceptions.handlers.EntityNotExistException;
import com.example.veterinaria.mappers.RazaMapper;
import com.example.veterinaria.services.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/razas")
public class RazaController {
    @Autowired
    private RazaMapper mapper;
    @Autowired
    private RazaService service;

    @GetMapping
    public ResponseEntity<List<RazaResponseDTO>> getAll(){
        List<RazaResponseDTO> razas= mapper.razaToRazaResponseDTOList(service.todasLasRazas());
        return ResponseEntity.ok(razas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaResponseDTO> getById(@PathVariable Long id){
        Optional<Raza> raza = service.buscarPorId(id);
        if(raza.isEmpty()){
            throw new EntityNotExistException("La entidad para el id ingresado no existe");
        }
        return ResponseEntity.ok(mapper.razaToRazaResponseDTO(raza.get()));
    }

    @PostMapping
    public ResponseEntity<RazaResponseDTO> postRaza(@Valid @RequestBody RazaCreationDTO razaCreationDTO){
        Raza guardada = service.cargarRaza(mapper.razaCreationDTOToRaza(razaCreationDTO));
        return ResponseEntity.ok(mapper.razaToRazaResponseDTO(guardada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRaza(@PathVariable Long id){
        if(service.eliminarRaza(id)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Raza was deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Raza not exists");
    }
}
