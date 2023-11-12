package com.example.ProyectoBancoJPA.dto;

import com.example.ProyectoBancoJPA.model.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class CuentaBancariaDTO {
    private BigDecimal balance;
    private Date fecha_apertura;
    private String cedula;

    public CuentaBancariaDTO(BigDecimal balance, String cedula) {
        this.balance = balance;
        this.fecha_apertura = new Date();
        this.cedula = cedula;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getCedulaCliente() {
        return cedula;
    }
    public Date getFecha_apertura() {
        return fecha_apertura;
    }
}
