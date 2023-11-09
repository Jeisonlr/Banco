package com.ProyectoIntegrador.Banco.repository;

import com.ProyectoIntegrador.Banco.model.Bolsillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolsilloRepository extends JpaRepository<Bolsillo, Long> {
}

