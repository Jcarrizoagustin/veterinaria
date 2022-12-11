package com.example.veterinaria.services;

import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public Optional<Mascota> buscarMascota(Long id){
        return mascotaRepository.findById(id);
    }

    public List<Mascota> todasLasMascotas(){
        return mascotaRepository.findAll();
    }

    public Mascota registrarMascota(Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    public boolean eliminarMascota(Long id){
        if(mascotaRepository.existsById(id)){
            mascotaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
