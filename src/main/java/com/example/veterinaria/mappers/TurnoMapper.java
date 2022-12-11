package com.example.veterinaria.mappers;

import com.example.veterinaria.dtos.turno.TurnoCreationDTO;
import com.example.veterinaria.dtos.turno.TurnoResponseDTO;
import com.example.veterinaria.entities.Mascota;
import com.example.veterinaria.entities.Turno;
import com.example.veterinaria.entities.handlers.MascotaNotExistException;
import com.example.veterinaria.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class TurnoMapper {
    @Autowired
    private MascotaService mascotaService;

    public Turno turnoCreationDTOToTurno(TurnoCreationDTO creationDTO){
        Turno turno = new Turno();
        int dia = creationDTO.getFecha().getDayOfMonth();
        int mes = creationDTO.getFecha().getMonthValue();
        int anio = creationDTO.getFecha().getYear();
        int hora = creationDTO.getHora().getHour();
        int minutos =creationDTO.getHora().getMinute();
        LocalDate fechaFinal = LocalDate.of(anio,mes,dia);
        LocalTime localTime = LocalTime.of(hora,minutos);
        turno.setFecha(fechaFinal);
        turno.setHora(localTime);
        Optional<Mascota> mascota = mascotaService.buscarMascota(creationDTO.getIdMascota());
        if(mascota.isEmpty()){
            throw new MascotaNotExistException("id: "+creationDTO.getIdMascota() );
        }
        turno.setMascota(mascota.get());
        return turno;
    }

    public TurnoResponseDTO turnoToTurnoResponseDTO(Turno turno){
        TurnoResponseDTO responseDTO = new TurnoResponseDTO();
        responseDTO.setId(turno.getId());
        LocalDate fecha = turno.getFecha();
        LocalTime hora = turno.getHora();
        responseDTO.setFecha(fecha.toString());
        responseDTO.setHora(hora.toString());
        responseDTO.setNombreMascota(turno.getMascota().getNombre().toString());
        responseDTO.setRazaMascota(turno.getMascota().getRaza().getNombre());
        responseDTO.setEspecieMascota(turno.getMascota().getRaza().getEspecie().getNombre());
        return responseDTO;
    }

    public List<TurnoResponseDTO> turnoToTurnoResponseDTOList(List<Turno> turnos){
        List<TurnoResponseDTO> dtos = turnos
                .stream()
                .map(turno -> turnoToTurnoResponseDTO(turno))
                .collect(Collectors.toList());
        return dtos;
    }
}
