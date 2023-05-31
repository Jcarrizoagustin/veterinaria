package com.example.veterinaria.controllers;

import com.example.veterinaria.dtos.mascota.MascotaCreationDTO;
import com.example.veterinaria.dtos.mascota.MascotaResponseDTO;
import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.exceptions.handlers.EntityNotExistException;
import com.example.veterinaria.mappers.MascotaMapper;
import com.example.veterinaria.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    @Autowired
    private MascotaMapper mapper;
    @Autowired
    private MascotaService service;

    @GetMapping
    public ResponseEntity<List<MascotaResponseDTO>> findAll(){
        return ResponseEntity.ok(mapper.mascotaToMascotaResponseDTOList(service.todasLasMascotas()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> findById(@Valid @PathVariable Long id){
        Optional<Mascota> mascota = service.buscarMascota(id);
        if(mascota.isPresent()){
            return ResponseEntity.ok(mapper.mascotaToMascotaResponseDTO(mascota.get()));
        }else{
            throw new EntityNotExistException("No existe");
        }
    }

    @PostMapping
    public ResponseEntity<MascotaResponseDTO> putMascota(@Valid @RequestBody MascotaCreationDTO mascotaCreation){
        Mascota mascota = mapper.mascotaCreationDTOToMascota(mascotaCreation);
        Mascota creada = service.registrarMascota(mascota);
        MascotaResponseDTO response = mapper.mascotaToMascotaResponseDTO(creada);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMascota(@Valid @PathVariable Long id){
        if(service.eliminarMascota(id)){
            return ResponseEntity.ok().build();
        }else{
            throw new EntityNotExistException("No existe");
        }
    }
}
