package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.Bolsillo;

import java.util.List;

public interface BolsilloService {
    Bolsillo createBolsillo(Bolsillo bolsillo);

    List<Bolsillo> getAllBolsillos();

    Bolsillo getBolsilloById(Integer id);

    Bolsillo updateBolsillo(Integer id, Bolsillo bolsilloActualizado);

    void deleteBolsillo(Integer id);

}
