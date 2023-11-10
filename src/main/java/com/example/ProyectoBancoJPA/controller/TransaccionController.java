package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.dto.TransferenciaExternaRequest;
import com.example.ProyectoBancoJPA.dto.TransferenciaInternaRequest;
import com.example.ProyectoBancoJPA.exceptions.SaldoInsuficienteException;
import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public Iterable<Transaccion> getAllTransacciones() {
        return transaccionService.getAllTransacciones();
    }

    @GetMapping("/{id}")
    public Transaccion getTransaccionById(@PathVariable Integer id) {
        return transaccionService.getTransaccionById(id);
    }

    @PutMapping("/{id}")
    public Transaccion updateTransaccion(@PathVariable Integer id, @RequestBody Transaccion updatedTransaccion) {
        return transaccionService.updateTransaccion(id, updatedTransaccion);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaccion(@PathVariable Integer id) {
        transaccionService.deleteTransaccion(id);
    }


    @PostMapping("/transferencia-interna")
    public ResponseEntity<Transaccion> realizarTransferenciaInterna(
            @RequestBody TransferenciaInternaRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarTransferenciaInterna(
                    request.getCuenta(),
                    request.getBolsillo(),
                    request.getMonto()
            );
            return new ResponseEntity<>(transaccion, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/transferencia-externa")
    public ResponseEntity<Transaccion> realizarTransferenciaExterna(
            @RequestBody TransferenciaExternaRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarTransferenciaInterna(
                    request.getCuenta(),
                    request.getBolsillo(),
                    request.getMonto()
            );
            return new ResponseEntity<>(transaccion, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }}