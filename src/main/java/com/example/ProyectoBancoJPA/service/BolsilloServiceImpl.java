package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.exceptions.BolsilloNoEncontradoException;
import com.example.ProyectoBancoJPA.exceptions.ClienteNoEncontradoException;
import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.BolsilloRepository;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  BolsilloServiceImpl implements BolsilloService {
    private  BolsilloRepository bolsilloRepository;
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    public BolsilloServiceImpl(BolsilloRepository bolsilloRepository, CuentaBancariaRepository cuentaBancariaRepository) {
        this.bolsilloRepository = bolsilloRepository;
        this.cuentaBancariaRepository = cuentaBancariaRepository;
    }
    @Override
    public Bolsillo createBolsillo(Bolsillo bolsillo) {
        CuentaBancaria cuentaBancariaAsociada = bolsillo.getCuentaBancaria();
        if (cuentaBancariaAsociada == null || cuentaBancariaRepository.findById(cuentaBancariaAsociada.getIdCuenta()).isEmpty()) {
            throw new ClienteNoEncontradoException("Es necesario un Cliente para crear la cuenta bancaria");
        }
        return bolsilloRepository.save(bolsillo);
    }

    @Override
    public List<Bolsillo> getAllBolsillos() {
        return bolsilloRepository.findAll();
    }

    @Override
    public Bolsillo getBolsilloById(Integer id) {
        return bolsilloRepository.findById(id).orElseThrow(() -> new BolsilloNoEncontradoException("No se encontró la cuenta bancaria con ID: " + id));
    }

    @Override
    public Bolsillo updateBolsillo(Integer id, Bolsillo bolsilloActualizado) {
        Optional<Bolsillo> bolsilloExistenteOptional = bolsilloRepository.findById(id);

        if (bolsilloExistenteOptional.isPresent()) {
            Bolsillo bolsilloExistente = bolsilloExistenteOptional.get();

            bolsilloExistente.setSaldo(bolsilloActualizado.getSaldo());
            bolsilloExistente.setNombreBolsillo(bolsilloActualizado.getNombreBolsillo());
            bolsilloExistente.setEstado(bolsilloActualizado.getEstado());

            return bolsilloRepository.save(bolsilloExistente);
        } else {
            throw new BolsilloNoEncontradoException("No se encontró la cuenta bancaria con ID: " + id);
        }
    }

    @Override
    public void deleteBolsillo(Integer id) {
        Optional<Bolsillo> bolsilloOptional = bolsilloRepository.findById(id);
        if (bolsilloOptional.isPresent()) {
            bolsilloRepository.deleteById(id);
        } else {
            throw new BolsilloNoEncontradoException("No se encontró la cuenta bancaria con ID: " + id);
        }
    }
}

