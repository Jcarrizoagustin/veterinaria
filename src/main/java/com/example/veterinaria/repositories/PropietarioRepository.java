package com.example.veterinaria.repositories;

import com.example.veterinaria.entities.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario,Long> {
}
