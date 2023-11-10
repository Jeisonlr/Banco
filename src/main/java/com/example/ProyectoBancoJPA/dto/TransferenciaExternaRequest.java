package com.example.ProyectoBancoJPA.dto;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferenciaExternaRequest {
    private CuentaBancaria cuenta;
    private Bolsillo bolsillo;
    private BigDecimal monto;
}
