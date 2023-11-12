package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Bolsillo;

import java.util.List;

public interface BolsilloService {
    Bolsillo createBolsillo(Bolsillo bolsillo) throws ApiRequestException;

    List<Bolsillo> getAllBolsillos();

    Bolsillo getBolsilloById(Integer id);

    Bolsillo updateBolsillo(Integer id, Bolsillo bolsilloActualizado);

    void deleteBolsillo(Integer id);

}
