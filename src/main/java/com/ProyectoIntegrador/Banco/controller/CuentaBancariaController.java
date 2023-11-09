package com.ProyectoIntegrador.Banco.controller;

import com.ProyectoIntegrador.Banco.model.CuentaBancaria;
import com.ProyectoIntegrador.Banco.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaBancariaController {
    private final CuentaBancariaService cuentaBancariaService;

    @Autowired
    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @GetMapping
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return cuentaBancariaService.getAllCuentasBancarias();
    }

    @GetMapping("/{idCuenta}")
    public CuentaBancaria getCuentaBancariaById(@PathVariable Long idCuenta) {
        return cuentaBancariaService.getCuentaBancariaById(idCuenta);
    }

    @PostMapping
    public CuentaBancaria crearCuentaBancaria(@RequestBody CuentaBancaria cuentaBancaria){
        return this.cuentaBancariaService.createCuentaBancaria(cuentaBancaria);
    }
}

