package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CuentaBancariaController {
    private CuentaBancariaService cuentaBancariaService;

    @Autowired
    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }
    @PostMapping("/cuentaBancaria")
    public CuentaBancaria crear (@RequestBody CuentaBancaria cuentaBancaria){
        return  this.cuentaBancariaService.crear(cuentaBancaria);
    }
}
