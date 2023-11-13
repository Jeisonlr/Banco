package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get-all")
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return cuentaBancariaService.getAllCuentasBancarias();
    }

    @GetMapping("/get/{id}")
    public CuentaBancaria getCuentaBancariaById(@PathVariable Integer idCuenta) {
        return cuentaBancariaService.getCuentaBancariaById(idCuenta);
    }

    @PostMapping("/create")
    public CuentaBancaria createCuentaBancaria(@RequestBody CuentaBancaria cuentaBancaria) {


        return this.cuentaBancariaService.createCuentaBancaria(cuentaBancaria);
    }

    @PutMapping("/update")
    public ResponseEntity<CuentaBancaria> updateCuentaBancaria(
            @PathVariable Integer idCuenta,
            @RequestBody CuentaBancaria cuentaBancariaActualizada) {
        try {
            CuentaBancaria cuentaActualizada = cuentaBancariaService.updateCuentaBancaria(idCuenta, cuentaBancariaActualizada);
            return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
        } catch (CuentaNoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}





