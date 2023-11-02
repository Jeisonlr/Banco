package com.example.banco.model;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pago",nullable = false)
    private Double monto;
    @Column(name = "fecha_movimiento",nullable = false)
    private Date fechaTransaccion;

    @Column(name = "transferencia")
    private double  transferencia;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "consignacion")
    private double consignacion;

    @ManyToOne
    @JoinColumn(name = "cuenta_bancaria_id")
    private CuentaBancaria cuentaBancaria;

    public Transaccion() {
    }

    public Transaccion(Integer id, Double monto, Date fechaTransaccion, double transferencia, String estado, double consignacion, CuentaBancaria cuentaBancaria) {
        this.id = id;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
        this.transferencia = transferencia;
        this.estado = estado;
        this.consignacion = consignacion;
        this.cuentaBancaria = cuentaBancaria;
    }
}
