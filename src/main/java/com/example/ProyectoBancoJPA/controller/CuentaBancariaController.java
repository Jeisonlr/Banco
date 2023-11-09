package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.dto.CuentaBancariaDTO;
import com.example.ProyectoBancoJPA.exceptions.ClienteNotFoundException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CuentaBancariaController {
    private CuentaBancariaService cuentaBancariaService;

    @Autowired
    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }
    @PostMapping("/crear")
    public ResponseEntity<CuentaBancariaDTO> crearCuentaBancaria(@RequestBody CuentaBancariaDTO cuentaBancariaDTO, @RequestParam Integer idCliente) {
        try {
            CuentaBancariaDTO nuevaCuenta = cuentaBancariaService.crear(cuentaBancariaDTO, idCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCuenta);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
