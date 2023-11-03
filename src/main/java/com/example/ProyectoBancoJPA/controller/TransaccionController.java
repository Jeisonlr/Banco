package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TransaccionController {
    private TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }
    @PostMapping("/transaccion")
    public Transaccion crear (@RequestBody Transaccion transaccion){
        return  this.transaccionService.crear(transaccion);
    }
}
