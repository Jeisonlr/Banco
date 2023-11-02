package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaService {
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    public CuentaBancariaService(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }

    public CuentaBancaria crear(CuentaBancaria cuentaBancaria) {
        return this.cuentaBancariaRepository.save(cuentaBancaria);
        }

    }

