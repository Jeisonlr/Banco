package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.dto.CuentaBancariaDTO;
import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;

import java.util.List;

public interface CuentaBancariaService {
    CuentaBancaria createCuentaBancaria(CuentaBancariaDTO cuentaBancariaDTO) throws ArithmeticException, ApiRequestException;

    List<CuentaBancaria> getAllCuentasBancarias();

    CuentaBancaria getCuentaBancariaById(Integer idCuenta);

    CuentaBancaria updateCuentaBancaria(Integer idCuenta, CuentaBancaria cuentaBancariaActualizada) throws CuentaNoEncontradaException;

    void deleteCuentaBancaria(Integer idCuenta);



}
