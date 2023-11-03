package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
import com.example.ProyectoBancoJPA.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BancoController {
  private TransaccionService transaccionService;

    @GetMapping("/demo")
    public String bienvenida(){
        return  "hola mundo";
    }

}
