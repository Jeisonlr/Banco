package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idtransaccion;
    @Column(name = "pago",nullable = false)
    private Double pago;
    @Column(name = "fecha_movimeinto",nullable = false)
    private Date fechaMovimiento;

    @Column(name = "tipo",nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuentaBancaria;


    public Transaccion() {
    }

    public Transaccion(Integer idtransaccion, Double pago, Date fechaMovimiento, String tipo, CuentaBancaria cuentaBancaria) {
        this.idtransaccion = idtransaccion;
        this.pago = pago;
        this.fechaMovimiento = fechaMovimiento;
        this.tipo = tipo;
        this.cuentaBancaria = cuentaBancaria;
    }

    public Integer getIdtransaccion() {
        return idtransaccion;
    }

    public Double getPago() {
        return pago;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idtransaccion=" + idtransaccion +
                ", pago=" + pago +
                ", fechaMovimiento=" + fechaMovimiento +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}