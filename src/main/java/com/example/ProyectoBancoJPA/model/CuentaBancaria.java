package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

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

    @Column(name = "balance")
    private BigDecimal balance;



    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "idCuenta=" + idCuenta +
                ", balance=" + balance +
                " , estado=" + estado +
                '}';
    }

    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bolsillo> bolsillos = new ArrayList<>();

}
