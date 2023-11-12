package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.BolsilloRepository;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  BolsilloServiceImpl implements BolsilloService {
    private  BolsilloRepository bolsilloRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public BolsilloServiceImpl(BolsilloRepository bolsilloRepository, ClienteRepository clienteRepository) {
        this.bolsilloRepository = bolsilloRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Bolsillo createBolsillo(Bolsillo bolsillo) throws ApiRequestException {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findByCedula(bolsillo.getCuentaBancaria().toString());
        if (clienteExistenteOptional.isPresent()) {
            return bolsilloRepository.save(bolsillo);
        } else {
            throw new ApiRequestException("No se pudo crear el bolsillo por que la cuenta bancaria asociada no existe.");
        }
    }

    @Override
    public List<Bolsillo> getAllBolsillos() {
        return bolsilloRepository.findAll();
    }

    @Override
    public Bolsillo getBolsilloById(Integer id) {
        return bolsilloRepository.findById(id).orElse(null);
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
            return null; // Manejo de error si el bolsillo no se encuentra.
        }
    }

    @Override
    public void deleteBolsillo(Integer id) {
        bolsilloRepository.deleteById(id);
    }
}

