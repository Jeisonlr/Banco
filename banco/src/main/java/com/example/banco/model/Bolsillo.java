package com.example.banco.model;
import jakarta.persistence.*;

@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre",nullable = false)
    private String nombreBolsillo;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "estado",nullable = false)
    private String estado;

    public Bolsillo() {
    }

    public Bolsillo(Integer idBolsillo, Double saldo, String nombreBolsillo) {
        this.id = idBolsillo;
        this.saldo = saldo;
        this.nombreBolsillo = nombreBolsillo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Bolsillo{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", nombreBolsillo='" + nombreBolsillo + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private CuentaBancaria cuentaBancaria;
}
