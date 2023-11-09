package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.Exceptions.BolsilloNoEncontradoException;
import com.ProyectoIntegrador.Banco.Exceptions.CuentaNoEncontradaException;
import com.ProyectoIntegrador.Banco.model.Bolsillo;
import com.ProyectoIntegrador.Banco.model.CuentaBancaria;
import com.ProyectoIntegrador.Banco.repository.BolsilloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
        import java.util.Optional;

@Service
public class  BolsilloServiceImpl implements BolsilloService {
    private final BolsilloRepository bolsilloRepository;
    private final CuentaBancariaServiceImpl cuentaBancariaService;

    @Autowired
    public BolsilloServiceImpl(BolsilloRepository bolsilloRepository, CuentaBancariaServiceImpl cuentaBancariaService) {
        this.bolsilloRepository = bolsilloRepository;
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @Override
    public Bolsillo createBolsillo(Long idCuenta, Bolsillo bolsillo)throws CuentaNoEncontradaException {
      CuentaBancaria optionalCuentaBancaria  = this.cuentaBancariaService.getCuentaBancariaById(idCuenta);




        return bolsilloRepository.save(bolsillo);
    }

    @Override
    public Bolsillo createBolsillo(Bolsillo bolsillo) {
        return null;
    }

    @Override
    public List<Bolsillo> getAllBolsillos() {
        return bolsilloRepository.findAll();
    }

    @Override
    public Bolsillo getBolsilloById(Long id) {
        return bolsilloRepository.findById(id).orElse(null);
    }

    @Override
    public Bolsillo updateBolsillo(Long id, Bolsillo bolsilloActualizado) throws BolsilloNoEncontradoException {
        Optional<Bolsillo> bolsilloExistenteOptional = bolsilloRepository.findById(id);

        if (bolsilloExistenteOptional.isPresent()) {
            Bolsillo bolsilloExistente = bolsilloExistenteOptional.get();

            bolsilloExistente.setSaldo(bolsilloActualizado.getSaldo());
            bolsilloExistente.setNombreBolsillo(bolsilloActualizado.getNombreBolsillo());
            bolsilloExistente.setEstado(bolsilloActualizado.getEstado());

            return bolsilloRepository.save(bolsilloExistente);
        } else {
            throw new BolsilloNoEncontradoException("El bolsillo no existe.");}
        }


    @Override
    public void deleteBolsillo(Long id) {
        bolsilloRepository.deleteById(id);
    }
}

