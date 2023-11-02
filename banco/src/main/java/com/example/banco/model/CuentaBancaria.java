package com.example.banco.model;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "CuentaBancaria")
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="saldo",nullable = false)
    private Double saldo;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "fecha_apertura", nullable = false)
    private Date fecha_apertura;

    @Column(name = "fecha_cierre")
    private Date fecha_cierre;

    @Column(name = "estado",nullable = false)
    private String estado;

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL)
    private List<Bolsillo> bolsillos;


    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer id, Double saldo, Cliente cliente, Date fecha_apertura, Date fecha_cierre, String estado, List<Bolsillo> bolsillos) {
        this.id = id;
        this.saldo = saldo;
        this.cliente = cliente;
        this.fecha_apertura = fecha_apertura;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.bolsillos = bolsillos;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", fecha_apertura=" + fecha_apertura +
                ", fecha_cierre=" + fecha_cierre +
                ", estado='" + estado + '\'' +
                ", bolsillos=" + bolsillos +
                '}';
    }

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL)
    private List<Transaccion> transaccions;
}
