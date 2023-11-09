package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
