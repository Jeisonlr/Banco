package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    boolean existsByCedula(String cedula);

    @Query("SELECT c FROM Cliente c WHERE c.cedula = :cedula")
    Optional<Cliente> findByCedula(@Param("cedula") String cedula);
}
