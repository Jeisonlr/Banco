package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombreBolsillo;
    @Column(name ="saldo",nullable = false)
    private BigDecimal saldo;
    @Column(name = "estado", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuentaBancaria;


    @Override
    public String toString() {
        return "Bolsillo{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", nombreBolsillo='" + nombreBolsillo + '\'' +
                '}';
    }
}