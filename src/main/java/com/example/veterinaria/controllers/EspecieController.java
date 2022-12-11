package com.example.veterinaria.controllers;

import com.example.veterinaria.dtos.especie.EspecieCreationDTO;
import com.example.veterinaria.dtos.especie.EspecieDTO;
import com.example.veterinaria.entities.Especie;
import com.example.veterinaria.entities.handlers.BadRequestException;
import com.example.veterinaria.mappers.EspecieMapper;
import com.example.veterinaria.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {
    @Autowired
    private EspecieMapper mapper;
    @Autowired
    private EspecieService especieService;

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> todasLasEspecies(){
        List<EspecieDTO> especieDTOList = mapper.especieToEspecieDTOList(especieService.todasLasEspecies());
        return ResponseEntity.ok(especieDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> especiePorId(@PathVariable Long id){
        if(id == 5){
            throw new BadRequestException("El id es necesario");
        }
        Optional<Especie> optional = especieService.buscarEspeciePorId(id);
        if(optional.isPresent()){
            EspecieDTO dto = mapper.especieToEspecieDTO(optional.get());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EspecieDTO> guardarEspecie(@Valid @RequestBody EspecieCreationDTO especieCreationDTO){
        Especie especie = mapper.especieCreationDTOtoEspecie(especieCreationDTO);
        Especie guardada = especieService.guardarEspecie(especie);
        return ResponseEntity.ok(mapper.especieToEspecieDTO(guardada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarEspecie(@PathVariable Long id){
        boolean result = especieService.eliminarEspecie(id);
        if(result){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
