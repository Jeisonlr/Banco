package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.Exceptions.BolsilloNoEncontradoException;
import com.ProyectoIntegrador.Banco.Exceptions.CuentaNoEncontradaException;
import com.ProyectoIntegrador.Banco.model.Bolsillo;

import java.util.List;

public interface BolsilloService {
    Bolsillo createBolsillo(Long idCuenta, Bolsillo bolsillo)throws CuentaNoEncontradaException;

    Bolsillo createBolsillo(Bolsillo bolsillo);

    List<Bolsillo> getAllBolsillos();

    Bolsillo getBolsilloById(Long id);

    Bolsillo updateBolsillo(Long id, Bolsillo bolsilloActualizado) throws BolsilloNoEncontradoException;

    void deleteBolsillo(Long id);

    // Agrega otros métodos para transferencias de fondos, pagos, etc.
}
