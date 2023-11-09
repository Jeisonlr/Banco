package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID,generator = "bolsillo_generator")
    @SequenceGenerator(name = "bolsillo_generator",allocationSize = 1)
    private Integer id;
    @Column(name ="saldo",nullable = false)
    private BigDecimal saldo;
    @Column(name = "NombreBolsillo",nullable = false)
    private String nombreBolsillo;
    @Column(name = "estado",nullable = false)
    private String estado;


    @ManyToOne
    @JoinColumn(name = "cuenta_bancaria_id")
    private CuentaBancaria cuentaBancaria;

    @OneToMany(mappedBy = "bolsillo")
    private List<Transaccion> transaction;

    }

