package com.ProyectoIntegrador.Banco.repository;

import org.springframework.data.repository.CrudRepository;
import com.ProyectoIntegrador.Banco.model.Transaccion;

public interface TransaccionRepository extends CrudRepository<Transaccion, Integer> {
    // You can define custom query methods if needed
}

