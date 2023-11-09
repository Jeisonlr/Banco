package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID,generator = "cuentaBancaria_generator")
    @SequenceGenerator(name = "cuentaBancaria_generator",allocationSize = 1)
    private Long idCuenta;

    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "password_transaction")
    private String passwordTransaction;

    @Column(name = "estado",nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuentaBancaria")
    private  List<Transaccion> transaction;

    @OneToMany(mappedBy = "cuentaBancaria")
    private List<Bolsillo> bolsillos = new ArrayList<>();

}
