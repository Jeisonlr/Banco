package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name = "transaccion_generator")
    private Integer id;
    @Column(name = "fechaTransaccion",nullable = false)
    private Date fechaTransaccion;
    @Column(name = "monto",nullable = false)
    private Double monto;
    @Column(name = "tipo",nullable = false)
    private String tipo;

    public Transaccion() {
    }

    public Transaccion(Integer idTransacion, Date fechaTransaccion, Double monto) {
        this.id = idTransacion;
        this.fechaTransaccion = fechaTransaccion;
        this.monto = monto;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "idTransacion=" + id +
                ", fechaTransaccion=" + fechaTransaccion +
                ", monto=" + monto +
                " ,tipo=" + tipo +
                '}';
    }
}
