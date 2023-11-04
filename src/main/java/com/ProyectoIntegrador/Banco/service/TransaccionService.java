package com.ProyectoIntegrador.Banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProyectoIntegrador.Banco.model.Transaccion;
import com.ProyectoIntegrador.Banco.repository.TransaccionRepository;

@Service
public class TransaccionService {

    private TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Iterable<Transaccion> getAllTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion getTransaccionById(Integer id) {
        return transaccionRepository.findById(id).orElse(null);
    }

    public Transaccion createTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Transaccion updateTransaccion(Integer id, Transaccion updatedTransaccion) {
        Transaccion existingTransaccion = transaccionRepository.findById(id).orElse(null);
        if (existingTransaccion != null) {
            existingTransaccion.setFechaTransaccion(updatedTransaccion.getFechaTransaccion());
            existingTransaccion.setMonto(updatedTransaccion.getMonto());
            existingTransaccion.setTipo(updatedTransaccion.getTipo());
            return transaccionRepository.save(existingTransaccion);
        }
        return null;
    }

    public void deleteTransaccion(Integer id) {
        transaccionRepository.deleteById(id);
    }
}

