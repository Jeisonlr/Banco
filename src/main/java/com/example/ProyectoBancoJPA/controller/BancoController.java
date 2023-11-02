package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
import com.example.ProyectoBancoJPA.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BancoController {
    private CuentaBancariaService cuentaBancariaService;
    private TransaccionService transaccionService;

    @Autowired
    public BancoController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }
    @PostMapping("/cuentaBancaria")
    public CuentaBancaria crear (@RequestBody CuentaBancaria cuentaBancaria){
        return  this.cuentaBancariaService.crear(cuentaBancaria);
    }

    @PostMapping("/transaccion")
    public Transaccion crear (@RequestBody Transaccion transaccion){
        return  this.transaccionService.crear(transaccion);
    }

}
