package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "cuentaBancaria_generator")
    @SequenceGenerator(name= "cuentaBancaria_generator", allocationSize = 1)
    private long idCuenta;
    @Column(name ="saldo", nullable = false)
    private Integer saldo;
    @Column(name = "estado",nullable = false)
    private String estado;

    public CuentaBancaria(){
    }

    public CuentaBancaria(long idCuenta, Integer saldo,String estado) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public long getSaldo() {
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
                " , estado=" + estado +
                '}';
    }
@OneToMany(mappedBy="cuentaBancaria", cascade = CascadeType.ALL)
private List<Transaccion> transaccion;
}
