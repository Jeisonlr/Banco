package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.model.Bolsillo;

import java.util.List;

public interface BolsilloService {
    Bolsillo createBolsillo(Bolsillo bolsillo);

    List<Bolsillo> getAllBolsillos();

    Bolsillo getBolsilloById(Long id);

    Bolsillo updateBolsillo(Long id, Bolsillo bolsilloActualizado);

    void deleteBolsillo(Long id);

    // Agrega otros métodos para transferencias de fondos, pagos, etc.
}
