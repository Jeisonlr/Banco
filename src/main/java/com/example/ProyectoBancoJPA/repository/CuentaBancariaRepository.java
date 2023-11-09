package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends CrudRepository<CuentaBancaria, Integer> {
}
