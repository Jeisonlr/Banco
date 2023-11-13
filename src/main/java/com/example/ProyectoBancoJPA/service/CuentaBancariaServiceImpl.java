package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final ClienteRepository clienteRepository;

    public CuentaBancariaServiceImpl(CuentaBancariaRepository cuentaBancariaRepository, ClienteRepository clienteRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public CuentaBancaria createCuentaBancaria(CuentaBancaria cuentaBancaria) throws ArithmeticException {
        // Validar que el balance sea mayor o igual a $20000
        BigDecimal saldoMinimo = new BigDecimal("20000");
        if (cuentaBancaria.getBalance().compareTo(saldoMinimo) < 0) {
            throw new ArithmeticException("El saldo mínimo requerido es de $20000");
        }

        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    @Override
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return (List<CuentaBancaria>) cuentaBancariaRepository.findAll();
    }

    @Override
    public CuentaBancaria getCuentaBancariaById(Integer idCuenta) {
        return cuentaBancariaRepository.findById(idCuenta)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la cuenta bancaria con ID: " + idCuenta));
    }

    @Override
    public CuentaBancaria updateCuentaBancaria(Integer idCuenta, CuentaBancaria cuentaBancariaActualizada) throws CuentaNoEncontradaException {
        Optional<CuentaBancaria> cuentaBancariaExistenteOptional = cuentaBancariaRepository.findById(idCuenta);

        if (cuentaBancariaExistenteOptional.isPresent()) {
            CuentaBancaria cuentaBancariaExistente = cuentaBancariaExistenteOptional.get();

            cuentaBancariaExistente.setBalance(cuentaBancariaActualizada.getBalance());
            cuentaBancariaExistente.setEstado(cuentaBancariaActualizada.getEstado());

            return cuentaBancariaRepository.save(cuentaBancariaExistente);
        } else {
            throw new CuentaNoEncontradaException("No se encontró la cuenta bancaria con ID: " + idCuenta);
        }
    }

    @Override
    public void deleteCuentaBancaria(Integer idCuenta)  {
        Optional<CuentaBancaria> cuentaBancariaOptional = cuentaBancariaRepository.findById(idCuenta);

        if (cuentaBancariaOptional.isPresent()) {
            CuentaBancaria cuentaBancaria = cuentaBancariaOptional.get();

            if (cuentaBancaria.getBalance().compareTo(BigDecimal.ZERO) != 0) {
                throw new ArithmeticException("No debe haber fondos en la cuenta para su eliminación");
            }
            cuentaBancariaRepository.delete(cuentaBancaria);
        } else {
            throw new CuentaNoEncontradaException("No se encontró la cuenta bancaria con ID: " + idCuenta);
        }
    }
}