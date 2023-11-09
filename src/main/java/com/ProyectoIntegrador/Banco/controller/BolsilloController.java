package com.ProyectoIntegrador.Banco.controller;

import com.ProyectoIntegrador.Banco.model.Bolsillo;
import com.ProyectoIntegrador.Banco.service.BolsilloService;
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

    @GetMapping
    public List<Bolsillo> getAllBolsillos() {
        return bolsilloService.getAllBolsillos();
    }

    @GetMapping("/{id}")
    public Bolsillo getBolsilloById(@PathVariable Long id) {
        return bolsilloService.getBolsilloById(id);
    }

    @PostMapping
    public Bolsillo crearBolsillo(@RequestBody Bolsillo bolsillo){
        return this.bolsilloService.createBolsillo(bolsillo);
    }
}
