package com.example.veterinaria.mappers;

import com.example.veterinaria.dtos.propietario.PropietarioCreationDTO;
import com.example.veterinaria.dtos.propietario.PropietarioResponseDTO;
import com.example.veterinaria.entities.Propietario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropietarioMapper {

    public Propietario propietarioCreationDTOToPropietario(PropietarioCreationDTO propietarioCreationDTO){
        Propietario propietario = new Propietario();
        propietario.setNombre(propietarioCreationDTO.getNombre());
        propietario.setApellido(propietarioCreationDTO.getApellido());
        propietario.setTelefono(propietarioCreationDTO.getTelefono());
        propietario.setDireccion(propietarioCreationDTO.getDireccion());
        return propietario;
    }

    public PropietarioResponseDTO propietarioToPropietarioDTO(Propietario propietario){
        PropietarioResponseDTO propietarioDTO = new PropietarioResponseDTO();
        propietarioDTO.setId(propietario.getId());
        propietarioDTO.setNombre(propietario.getNombre());
        propietarioDTO.setApellido(propietario.getApellido());
        propietarioDTO.setTelefono(propietario.getTelefono());
        propietarioDTO.setDireccion(propietario.getDireccion());
        return propietarioDTO;
    }

    public List<PropietarioResponseDTO> propietarioToPropietarioResponseDTOList(List<Propietario> propietarios){
        List<PropietarioResponseDTO> result = propietarios
                .stream()
                .map(propietario -> propietarioToPropietarioDTO(propietario))
                .collect(Collectors.toList());
        return result;
    }
}
