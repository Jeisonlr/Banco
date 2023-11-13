package com.example.ProyectoBancoJPA.dto;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferenciaExternaRequest {
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;
    private BigDecimal monto;
}
