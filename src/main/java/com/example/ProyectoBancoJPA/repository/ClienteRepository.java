package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
