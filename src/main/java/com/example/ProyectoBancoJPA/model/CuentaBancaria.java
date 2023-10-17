package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "cuentaBancaria_generator")
    @SequenceGenerator(name= "cuentaBancaria_generator", allocationSize = 1)
    private Integer idCuenta;
    @Column(name ="saldo",nullable = false)
    private Integer saldo;
    @Column(name = "estado",nullable = false)
    private String estado;

    public CuentaBancaria(){
    }

    public CuentaBancaria(Integer idCuenta, Integer saldo,String estado) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta=" + idCuenta +
                ", saldo=" + saldo +
                " , estado" + estado +
                '}';
    }
@OneToMany(mappedBy="cuentaBancaria", cascade = CascadeType.ALL)
private List<Transaccion> transaccion;
}
