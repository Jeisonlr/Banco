package com.example.ProyectoBancoJPA.dto;

import java.util.Date;

public class CuentaBancariaDTO {
    private Integer saldo;
    private Date fecha_apertura;


    public CuentaBancariaDTO(Integer saldo, Date fecha_apertura) {
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
    }

    public Integer getSaldo() {
        return saldo;
    }


    public Date getFecha_apertura() {
        return fecha_apertura;
    }
}
