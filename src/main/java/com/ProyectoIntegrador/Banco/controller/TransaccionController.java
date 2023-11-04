package com.ProyectoIntegrador.Banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ProyectoIntegrador.Banco.model.Transaccion;
import com.ProyectoIntegrador.Banco.service.TransaccionService;

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

    @PostMapping
    public Transaccion createTransaccion(@RequestBody Transaccion transaccion) {
        return transaccionService.createTransaccion(transaccion);
    }

    @PutMapping("/{id}")
    public Transaccion updateTransaccion(@PathVariable Integer id, @RequestBody Transaccion updatedTransaccion) {
        return transaccionService.updateTransaccion(id, updatedTransaccion);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaccion(@PathVariable Integer id) {
        transaccionService.deleteTransaccion(id);
    }
}
