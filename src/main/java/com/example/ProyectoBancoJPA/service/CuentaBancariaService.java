package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.dto.CuentaBancariaDTO;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class CuentaBancariaService {
    private CuentaBancariaRepository cuentaBancariaRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public CuentaBancariaService(CuentaBancariaRepository cuentaBancariaRepository, ClienteRepository clienteRepository) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.clienteRepository = clienteRepository;
    }

    public CuentaBancariaDTO crear(CuentaBancariaDTO cuentaBancariaDTO, Integer idCliente) {
        Random random = new Random();
        Integer id = random.nextInt(1001);
        Optional<Cliente> ClienteOptional = clienteRepository.findById(idCliente);
        Cliente clienteEncontrado = ClienteOptional.get();

        CuentaBancaria cuentabancaria = new CuentaBancaria(
                id,
                cuentaBancariaDTO.getSaldo(),
                clienteEncontrado,
                cuentaBancariaDTO.getFecha_apertura(),
                null,
                "Activa",
                "Makaia");
        return cuentaBancariaDTO;
        }

    }

