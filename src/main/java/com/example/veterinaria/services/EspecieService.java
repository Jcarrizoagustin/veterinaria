package com.example.veterinaria.services;

import com.example.veterinaria.entities.Especie;
import com.example.veterinaria.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository repository;

    public Especie guardarEspecie(Especie especie){
        return repository.save(especie);
    }

    public Optional<Especie> buscarEspeciePorId(Long id){
        return repository.findById(id);
    }

    public Especie buscarEspeciePorNombre(String nombre){
        return repository.findByNombre(nombre);
    }

    public boolean eliminarEspecie(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Especie> todasLasEspecies(){
        return repository.findAll();
    }
}
