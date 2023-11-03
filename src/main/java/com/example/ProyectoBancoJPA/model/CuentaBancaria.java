package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    @Column(name = "saldo", nullable = false)
    private Integer saldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "fecha_apertura", nullable = false)
    private Date fecha_apertura;

    @Column(name = "fecha_cierre")
    private Date fecha_cierre;
    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "banco_nombre", nullable = false)
    private String banco;
    public CuentaBancaria(){
    }

    public CuentaBancaria(Integer idCuenta, Integer saldo, Cliente cliente, Date fecha_apertura, Date fecha_cierre, String estado, String banco) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.fecha_apertura = fecha_apertura;
        this.fecha_cierre = fecha_cierre;
        this.estado = estado;
        this.banco = banco;
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

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bolsillo> bolsillos = new ArrayList<>();

}
