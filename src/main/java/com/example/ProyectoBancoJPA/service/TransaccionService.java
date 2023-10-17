package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    private TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Transaccion crear(Transaccion transaccion) {
        if(transaccion.getIdtransaccion() == null) {
            throw new IllegalArgumentException("La id esta nula");
        }
       return this.transaccionRepository.save(transaccion);
    }
}
