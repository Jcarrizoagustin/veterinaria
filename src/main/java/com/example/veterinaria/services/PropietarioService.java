package com.example.veterinaria.services;

import com.example.veterinaria.dtos.propietario.PropietarioCreationDTO;
import com.example.veterinaria.dtos.propietario.PropietarioResponseDTO;
import com.example.veterinaria.entities.Propietario;
import com.example.veterinaria.exceptions.handlers.PropietarioNotExistException;
import com.example.veterinaria.mappers.PropietarioMapper;
import com.example.veterinaria.repositories.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {
    @Autowired
    private PropietarioMapper mapper;
    @Autowired
    private PropietarioRepository repository;

    public List<Propietario> getPropietarios(){
        return repository.findAll();
    }

    public PropietarioResponseDTO guardarPropietario(PropietarioCreationDTO prop){
        Propietario propietario = repository.save(mapper.propietarioCreationDTOToPropietario(prop));
        return mapper.propietarioToPropietarioDTO(propietario);
    }

    public Optional<Propietario> buscarPorId(Long id){
        return repository.findById(id);

    }

    public void eliminarPropietario(Long id){
        if(!repository.existsById(id)){
            throw new PropietarioNotExistException("El usuario con id: " + id +" no se encuentra registrado");
        }else{
            repository.deleteById(id);
        }
    }


}
