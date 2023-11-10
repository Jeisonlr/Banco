package com.ProyectoIntegrador.Banco.repository;

import com.ProyectoIntegrador.Banco.model.Transaccion;

import java.time.LocalDateTime;

public class TransaccionRepositoryImpl {
    public Transaccion externaDB() {
    Transaccion transaccion = new Transaccion();
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccion.setMonto(monto);
        transaccion.setTipoTransaccion("Externa");
        transaccion.setNumeroCuentaEnvia(cuentaOrigen.getIdCuenta().toString());
        transaccion.setNumeroCuentaRecibe(cuentaDestino.getIdCuenta().toString());
        transaccion.setCuentaBancaria(cuentaOrigen);
        return transaccionRepository.save(transaccion);
}
