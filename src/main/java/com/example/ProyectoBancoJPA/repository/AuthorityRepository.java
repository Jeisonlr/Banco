package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.Authority;
import com.example.ProyectoBancoJPA.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {

    Optional<Authority> findByName(AuthorityName name);

}
