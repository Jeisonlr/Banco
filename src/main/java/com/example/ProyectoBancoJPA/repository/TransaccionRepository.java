package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Transaccion;
import org.springframework.data.repository.CrudRepository;

public interface TransaccionRepository extends CrudRepository<Transaccion,Integer> {
}
