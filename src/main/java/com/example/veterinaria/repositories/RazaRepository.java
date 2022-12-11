package com.example.veterinaria.repositories;

import com.example.veterinaria.entities.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepository extends JpaRepository<Raza,Long> {
}
