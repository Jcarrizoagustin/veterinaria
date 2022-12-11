package com.example.veterinaria.repositories;

import com.example.veterinaria.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie,Long> {

   Especie findByNombre(String name);
}
