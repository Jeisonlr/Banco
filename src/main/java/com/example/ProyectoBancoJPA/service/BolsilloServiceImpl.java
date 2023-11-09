package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.repository.BolsilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  BolsilloServiceImpl implements BolsilloService {
    private  BolsilloRepository bolsilloRepository;

    @Autowired
    public BolsilloServiceImpl(BolsilloRepository bolsilloRepository) {
        this.bolsilloRepository = bolsilloRepository;
    }

    @Override
    public Bolsillo createBolsillo(Bolsillo bolsillo) {
        return bolsilloRepository.save(bolsillo);
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

