package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.service.BolsilloService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolsillos")
public class BolsilloController {
    private final BolsilloService bolsilloService;

    @Autowired
    public BolsilloController(BolsilloService bolsilloService) {
        this.bolsilloService = bolsilloService;
    }

    @GetMapping("/{id}")
    public Bolsillo getBolsilloById(@PathVariable Integer id) {
        return bolsilloService.getBolsilloById(id);
    }

    @PostMapping
    public Bolsillo crearBolsillo(@RequestBody Bolsillo bolsillo){
        return this.bolsilloService.createBolsillo(bolsillo);
    }
}
