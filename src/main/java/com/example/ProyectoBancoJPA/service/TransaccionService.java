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
        return this.transaccionRepository.save(transaccion);
        }

    public Iterable<Transaccion> getAllTransacciones(){
        return null;
    }

    public Transaccion getTransaccionById(Integer id) {
        return null;
    }

    public Transaccion updateTransaccion(Integer id, Transaccion updatedTransaccion) {
        return null;
    }

    public void deleteTransaccion(Integer id) {
    }
}

