package com.example.veterinaria.mappers;

import com.example.veterinaria.dtos.mascota.MascotaCreationDTO;
import com.example.veterinaria.dtos.mascota.MascotaResponseDTO;
import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.entities.Propietario;
import com.example.veterinaria.entities.Raza;
import com.example.veterinaria.entities.handlers.PropietarioNotExistException;
import com.example.veterinaria.entities.handlers.RazaNotExistException;
import com.example.veterinaria.services.PropietarioService;
import com.example.veterinaria.services.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MascotaMapper {
    @Autowired
    private RazaService razaService;
    @Autowired
    private PropietarioService propietarioService;

    public Mascota mascotaCreationDTOToMascota(MascotaCreationDTO mascotaCreationDTO){
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaCreationDTO.getNombre());
        Optional<Propietario> propietario = propietarioService.buscarPorId(mascotaCreationDTO.getIdPropietario());
        if(propietario.isEmpty()){
            throw new PropietarioNotExistException("id: "+mascotaCreationDTO.getIdPropietario());
        }
        Optional<Raza> raza = razaService.buscarPorId(mascotaCreationDTO.getIdRaza());
        if(raza.isEmpty()){
            throw new RazaNotExistException("id: "+mascotaCreationDTO.getIdRaza());
        }
        mascota.setPropietario(propietario.get());
        mascota.setRaza(raza.get());
        return mascota;
    }

    public MascotaResponseDTO mascotaToMascotaResponseDTO(Mascota mascota){
        MascotaResponseDTO responseDTO = new MascotaResponseDTO();
        responseDTO.setId(mascota.getId());
        responseDTO.setNombre(mascota.getNombre());
        responseDTO.setEspecie(mascota.getRaza().getEspecie().getNombre());
        responseDTO.setRaza(mascota.getRaza().getNombre());
        responseDTO.setPropietario(mascota.getPropietario().getApellido() + " " + mascota.getPropietario().getNombre());
        return responseDTO;
    }

    public List<MascotaResponseDTO> mascotaToMascotaResponseDTOList(List<Mascota> mascotas){
        List<MascotaResponseDTO> response = mascotas
                .stream()
                .map(mascota -> mascotaToMascotaResponseDTO(mascota))
                .collect(Collectors.toList());
        return response;
    }
}
