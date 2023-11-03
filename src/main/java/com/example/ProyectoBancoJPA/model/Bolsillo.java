package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombreBolsillo;
    @Column(name ="saldo", nullable = false)
    private Double saldo;
    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuentaBancaria;

    public Bolsillo() {
    }

    public Bolsillo(Integer id, String nombreBolsillo, Double saldo, String estado, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.nombreBolsillo = nombreBolsillo;
        this.saldo = saldo;
        this.estado = estado;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public String toString() {
        return "Bolsillo{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", nombreBolsillo='" + nombreBolsillo + '\'' +
                '}';
    }
}