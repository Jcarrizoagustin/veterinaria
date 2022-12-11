package com.example.veterinaria.mappers;

import com.example.veterinaria.dtos.especie.EspecieCreationDTO;
import com.example.veterinaria.dtos.especie.EspecieDTO;
import com.example.veterinaria.entities.Especie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EspecieMapper {
       public Especie especieCreationDTOtoEspecie(EspecieCreationDTO especieCreation){
           Especie especie = new Especie();
           especie.setNombre(especieCreation.getNombre());
           return especie;
       }

       public EspecieDTO especieToEspecieDTO(Especie especie){
           EspecieDTO especieDTO = new EspecieDTO();
           especieDTO.setId(especie.getId());
           especieDTO.setNombre(especie.getNombre());
           return especieDTO;
       }

       public List<EspecieDTO> especieToEspecieDTOList(List<Especie> especies){
           List<EspecieDTO> response = especies
                   .stream()
                   .map(especie -> especieToEspecieDTO(especie))
                   .collect(Collectors.toList());
           return response;
       }


}
