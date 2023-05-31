package com.example.veterinaria.mappers;

import com.example.veterinaria.dtos.raza.RazaCreationDTO;
import com.example.veterinaria.dtos.raza.RazaResponseDTO;
import com.example.veterinaria.entities.Especie;
import com.example.veterinaria.entities.Raza;
import com.example.veterinaria.exceptions.handlers.EspecieEntityNotExist;
import com.example.veterinaria.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RazaMapper {

    @Autowired
    private EspecieService especieService;

    public Raza razaCreationDTOToRaza(RazaCreationDTO razaCreationDTO){
        Raza raza = new Raza();
        Optional<Especie> especie = especieService.buscarEspeciePorId(razaCreationDTO.getIdEspecie());
        if(especie.isEmpty()){
            throw new EspecieEntityNotExist("Especie no existe para el idEspecie ingresado");
        }
        raza.setNombre(razaCreationDTO.getNombre());
        raza.setEspecie(especie.get());
        return raza;
    }

    public RazaResponseDTO razaToRazaResponseDTO(Raza raza){
        RazaResponseDTO razaResponseDTO = new RazaResponseDTO();
        razaResponseDTO.setId(raza.getId());
        razaResponseDTO.setNombre(raza.getNombre());
        razaResponseDTO.setEspecie(raza.getEspecie().getNombre());
        return razaResponseDTO;
    }

    public List<RazaResponseDTO> razaToRazaResponseDTOList(List<Raza> razas){
        List<RazaResponseDTO> response = razas
                .stream()
                .map(raza -> razaToRazaResponseDTO(raza))
                .collect(Collectors.toList());
        return response;
    }
}
