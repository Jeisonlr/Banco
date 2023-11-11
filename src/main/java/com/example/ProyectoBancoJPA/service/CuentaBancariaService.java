package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;

import java.util.List;

public interface CuentaBancariaService {
    CuentaBancaria createCuentaBancaria(CuentaBancaria cuentaBancaria);

    List<CuentaBancaria> getAllCuentasBancarias();

    CuentaBancaria getCuentaBancariaById(Integer idCuenta);

    CuentaBancaria updateCuentaBancaria(Integer idCuenta, CuentaBancaria cuentaBancariaActualizada) throws CuentaNoEncontradaException;

    void deleteCuentaBancaria(Integer idCuenta);



}
