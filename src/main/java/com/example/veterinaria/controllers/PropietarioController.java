package com.example.veterinaria.controllers;

import com.example.veterinaria.dtos.propietario.PropietarioCreationDTO;
import com.example.veterinaria.dtos.propietario.PropietarioResponseDTO;
import com.example.veterinaria.entities.Propietario;
import com.example.veterinaria.exceptions.handlers.PropietarioNotExistException;
import com.example.veterinaria.mappers.PropietarioMapper;
import com.example.veterinaria.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {
    @Autowired
    private PropietarioMapper mapper;
    @Autowired
    private PropietarioService service;

    @GetMapping
    public List<PropietarioResponseDTO> getAll(){
        return mapper.propietarioToPropietarioResponseDTOList(service.getPropietarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropietarioResponseDTO> getPropietarioById(@PathVariable Long id){
        Optional<Propietario> propietarioOptional = service.buscarPorId(id);
        if(propietarioOptional.isEmpty()){
            throw new PropietarioNotExistException("El propietario con id: "+ id +" no se encuentra registrado");
        }
        PropietarioResponseDTO dto = mapper.propietarioToPropietarioDTO(propietarioOptional.get());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public PropietarioResponseDTO savePropietario(@Valid @RequestBody PropietarioCreationDTO prop){
        return service.guardarPropietario(prop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.eliminarPropietario(id);
        return ResponseEntity.noContent().build();
    }
}
