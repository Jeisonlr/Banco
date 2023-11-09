package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.model.CuentaBancaria;

import java.util.List;

public interface CuentaBancariaService {
    CuentaBancaria createCuentaBancaria(CuentaBancaria cuentaBancaria);

    List<CuentaBancaria> getAllCuentasBancarias();

    CuentaBancaria getCuentaBancariaById(Long idCuenta);

    CuentaBancaria updateCuentaBancaria(Long idCuenta, CuentaBancaria cuentaBancariaActualizada);

    void deleteCuentaBancaria(Long idCuenta);

    // Agrega otros métodos para transferencias de fondos, pagos, etc.
}
