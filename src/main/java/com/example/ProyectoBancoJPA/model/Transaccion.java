package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Integer id;
    @Column(name = "fechaTransaccion",nullable = false)
    private LocalDateTime fechaTransaccion;
    @Column(name = "monto",nullable = false)
    private BigDecimal monto;
    @Column(name = "tipoTransaccion",nullable = false)
    private String tipoTransaccion;

    @Column(name = "numero_cuenta_envia")
    private String numeroCuentaEnvia;

    @Column(name = "numero_cuenta_recibe")
    private  String  numeroCuentaRecibe;


    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private  CuentaBancaria cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "id_bolsillo")
    private  Bolsillo bolsillo ;
}