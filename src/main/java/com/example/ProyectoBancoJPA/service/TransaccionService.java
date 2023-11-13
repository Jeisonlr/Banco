package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.repository.TransaccionRepository;
import com.example.ProyectoBancoJPA.exceptions.SaldoInsuficienteException;
import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Iterable<Transaccion> getAllTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion getTransaccionById(Integer id) {
        return transaccionRepository.findById(id).orElse(null);
    }

    public Transaccion createTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Transaccion updateTransaccion(Integer id, Transaccion updatedTransaccion) {
        Transaccion existingTransaccion = transaccionRepository.findById(id).orElse(null);
        if (existingTransaccion != null) {
            existingTransaccion.setFechaTransaccion(updatedTransaccion.getFechaTransaccion());
            existingTransaccion.setMonto(updatedTransaccion.getMonto());
            existingTransaccion.setTipoTransaccion(updatedTransaccion.getTipoTransaccion());
            return transaccionRepository.save(existingTransaccion);
        }
        return null;
    }

    public void deleteTransaccion(Integer id) {
        transaccionRepository.deleteById(id);
    }


    public Transaccion realizarTransferenciaExterna(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, BigDecimal monto) throws SaldoInsuficienteException {
        // Validar disponibilidad de fondos en la cuenta origen.

        if (cuentaOrigen.getBalance().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException("Fondos insuficientes en la cuenta origen.");
        }
        // Realizar la transacción restando el monto de la cuenta origen y sumándolo a la cuenta destino.
        Transaccion transaccion = new Transaccion();
        cuentaOrigen.setBalance(cuentaOrigen.getBalance().subtract(monto));
        cuentaDestino.setBalance(cuentaDestino.getBalance().add(monto));
        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarTransferenciaInterna(CuentaBancaria cuenta, Bolsillo bolsillo, BigDecimal monto) throws SaldoInsuficienteException {
        // Validar disponibilidad de fondos en la cuenta.
        if (cuenta.getBalance().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException("Fondos insuficientes en la cuenta bancaria.");
        }

        // Realizar la transacción restando el monto de la cuenta y sumándolo al bolsillo.
        cuenta.setBalance(cuenta.getBalance().subtract(monto));
        bolsillo.setSaldo(bolsillo.getSaldo().add(monto));

        // Registrar la transacción en la base de datos.
        Transaccion transaccion = new Transaccion();
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccion.setMonto(monto);
        transaccion.setTipoTransaccion("Interna");
        transaccion.setNumeroCuentaEnvia(cuenta.getIdCuenta().toString());
        transaccion.setNumeroCuentaRecibe(bolsillo.getId().toString());
        transaccion.setCuentaBancaria(cuenta);
        transaccion.setBolsillo(bolsillo);
        return transaccionRepository.save(transaccion);
    }
}
