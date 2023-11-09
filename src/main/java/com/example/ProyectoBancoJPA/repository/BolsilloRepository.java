package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolsilloRepository extends JpaRepository<Bolsillo, Integer> {
}

