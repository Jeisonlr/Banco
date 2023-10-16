package com.example.banco.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "cuentaBancaria_generator")
    @SequenceGenerator(name = "cuentaBancaria_generator", allocationSize = 1)
    private Long idCuenta;
    @Column(name ="saldo",nullable = false)
    private Double saldo;
    @Column(name = "estado",nullable = false)
    private String estado;

    public CuentaBancaria(){
    }

    public CuentaBancaria(Long idCuenta, Double saldo) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta=" + idCuenta +
                ", saldo=" + saldo +
                " , estado" + estado +
                '}';
    }

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL)
    private List<Bolsillo> bolsillos;
}
