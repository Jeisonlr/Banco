package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
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
        return cuentaBancariaRepository.findById(idCuenta).orElse(null);
    }

    @Override
    public CuentaBancaria updateCuentaBancaria(Integer idCuenta, CuentaBancaria cuentaBancariaActualizada) {
        Optional<CuentaBancaria> cuentaBancariaExistenteOptional = cuentaBancariaRepository.findById(idCuenta);

        if (cuentaBancariaExistenteOptional.isPresent()) {
            CuentaBancaria cuentaBancariaExistente = cuentaBancariaExistenteOptional.get();

            cuentaBancariaExistente.setBalance(cuentaBancariaActualizada.getBalance());
            cuentaBancariaExistente.setEstado(cuentaBancariaActualizada.getEstado());

            return cuentaBancariaRepository.save(cuentaBancariaExistente);
        } else {
            return null; // Manejo de error si la cuenta bancaria no se encuentra.
        }
    }
    @Override
    public void deleteCuentaBancaria(Integer idCuenta) {
        cuentaBancariaRepository.deleteById(idCuenta);
    }
}