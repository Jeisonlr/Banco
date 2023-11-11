package com.example.ProyectoBancoJPA.repository;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.model.Transaccion;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class TransaccionRepositoryImpl{
    private TransaccionRepository transaccionRepository;
    public Transaccion externaDB(BigDecimal monto, CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        Transaccion transaccion = new Transaccion();
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccion.setMonto(monto);
        transaccion.setTipoTransaccion("Externa");
        transaccion.setNumeroCuentaEnvia(cuentaOrigen.getIdCuenta().toString());
        transaccion.setNumeroCuentaRecibe(cuentaDestino.getIdCuenta().toString());
        transaccion.setCuentaBancaria(cuentaOrigen);
        return transaccionRepository.save(transaccion);
    }
}
