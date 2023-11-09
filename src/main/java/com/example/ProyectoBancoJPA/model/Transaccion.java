package com.example.ProyectoBancoJPA.model;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idtransaccion;
    @Column(name = "pago",nullable = false)
    private Double pago;
    @Column(name = "fecha_movimeinto",nullable = false)
    private Date fechaMovimiento;

    @Column(name = "tipo",nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "id_bolsillo")
    private Bolsillo bolsillo;

    @Override
    public String toString() {
        return "Transaccion{" +
                "idtransaccion=" + idtransaccion +
                ", pago=" + pago +
                ", fechaMovimiento=" + fechaMovimiento +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}