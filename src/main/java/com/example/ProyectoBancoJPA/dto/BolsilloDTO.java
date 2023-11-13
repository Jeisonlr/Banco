package com.example.ProyectoBancoJPA.dto;

import com.example.ProyectoBancoJPA.model.CuentaBancaria;

public class BolsilloDTO {
    private Integer id;
    private String nombreBolsillo;
    private Double saldo;
    private String estado;

    public BolsilloDTO(String nombreBolsillo, Double saldo, String estado, CuentaBancaria cuentaBancaria) {
        this.nombreBolsillo = nombreBolsillo;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreBolsillo() {
        return nombreBolsillo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getEstado() {
        return estado;
    }
}
