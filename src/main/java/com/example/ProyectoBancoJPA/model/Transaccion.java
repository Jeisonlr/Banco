package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name = "transaccion_generator",allocationSize = 1 )
    private long idtransaccion;

    @Column(name = "fechaTransaccion",nullable = false)
    private Date fechaTransaccion;

    @Column(name = "monto",nullable = false)
    private Double monto;

    @Column(name = "tipo",nullable = false)
    private String tipo;

    public Transaccion() {
    }

    public Transaccion(long idTransacion, Date fechaTransaccion, Double monto,String tipo){
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.tipo = tipo;
    }

    public long getIdtransaccion() {
        return idtransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransacion=" + idtransaccion +
                ", fechaTransaccion=" + fechaTransaccion +
                ", monto=" + monto +
                " ,tipo=" + tipo +
                '}';
    }
    @ManyToOne
    @JoinColumn(name = "cuentaBancaria_id")
    private CuentaBancaria cuentaBancaria;

}