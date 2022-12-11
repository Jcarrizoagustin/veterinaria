package com.example.veterinaria.services;

import com.example.veterinaria.entities.Raza;
import com.example.veterinaria.repositories.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazaService {
    @Autowired
    private RazaRepository repository;

    public List<Raza> todasLasRazas(){
        return repository.findAll();
    }

    public Raza cargarRaza(Raza raza){
        return repository.save(raza);
    }

    public Optional<Raza> buscarPorId(Long id){
         return repository.findById(id);
    }

    public boolean eliminarRaza(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }return false;
    }
}
