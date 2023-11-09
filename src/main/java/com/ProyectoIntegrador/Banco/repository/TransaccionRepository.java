package com.ProyectoIntegrador.Banco.repository;

import org.springframework.data.repository.CrudRepository;
import com.ProyectoIntegrador.Banco.model.Transaccion;

import java.time.LocalDateTime;

public interface TransaccionRepository extends CrudRepository<Transaccion, Integer> {


}

