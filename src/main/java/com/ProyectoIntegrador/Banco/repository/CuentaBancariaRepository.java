package com.ProyectoIntegrador.Banco.repository;

import com.ProyectoIntegrador.Banco.model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
}
