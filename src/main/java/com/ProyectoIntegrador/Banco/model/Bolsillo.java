package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolsillo_generator",allocationSize = 1)
    private Long id;
    @Column(name ="saldo",nullable = false)
    private Double saldo;
    @Column(name = "nombreBolsillo",nullable = false)
    private String nobreBolsillo;
    @Column(name = "estado",nullable = false)
    private String estado;

    public Bolsillo() {
    }

    public Bolsillo(Long idBolsillo, Double saldo, String nobreBolsillo) {
        this.id = idBolsillo;
        this.saldo = saldo;
        this.nobreBolsillo = nobreBolsillo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Bolsillo{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", nobreBolsillo='" + nobreBolsillo + '\'' +
                '}';
    }
}
