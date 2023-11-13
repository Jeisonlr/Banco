package com.example.ProyectoBancoJPA.dto;

public class TransaccionDTO {
    private Long idCuentaBancaria;
    private double monto;

    public TransaccionDTO() {
    }

    public TransaccionDTO(Long idCuentaBancaria, double monto) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.monto = monto;
    }

    public Long getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public double getMonto() {
        return monto;
    }
}
