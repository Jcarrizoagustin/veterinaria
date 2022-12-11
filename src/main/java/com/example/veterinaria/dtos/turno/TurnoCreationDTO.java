package com.example.veterinaria.dtos.turno;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class TurnoCreationDTO {
    @JsonFormat(pattern ="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE) @NotNull
    @Getter @Setter
    private LocalDate fecha;

    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(pattern = "HH:mm",iso = DateTimeFormat.ISO.TIME) @NotNull
    @Getter @Setter
    private LocalTime hora;

    @NotNull
    @Getter @Setter
    private Long idMascota;
}
