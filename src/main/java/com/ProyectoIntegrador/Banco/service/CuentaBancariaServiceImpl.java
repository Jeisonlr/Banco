package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.model.CuentaBancaria;
import com.ProyectoIntegrador.Banco.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
    private final CuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    public CuentaBancariaServiceImpl(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    @Override
    public CuentaBancaria createCuentaBancaria(CuentaBancaria cuentaBancaria) {
        return cuentaBancariaRepository.save(cuentaBancaria);
    }

    @Override
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return cuentaBancariaRepository.findAll();
    }

    @Override
    public CuentaBancaria getCuentaBancariaById(Long idCuenta) {
        return cuentaBancariaRepository.findById(idCuenta).orElse(null);
    }

    @Override
    public CuentaBancaria updateCuentaBancaria(Long idCuenta, CuentaBancaria cuentaBancariaActualizada) {
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
    public void deleteCuentaBancaria(Long idCuenta) {
        cuentaBancariaRepository.deleteById(idCuenta);
    }
}

