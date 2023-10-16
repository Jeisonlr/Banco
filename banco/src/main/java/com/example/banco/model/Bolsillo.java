package com.example.banco.model;
import jakarta.persistence.*;

@Entity
@Table(name = "bolsillo")
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolsillo_generator", allocationSize = 1)
    private Long id;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "nombreBolsillo",nullable = false)
    private String nombreBolsillo;
    @Column(name = "estado",nullable = false)
    private String estado;

    public Bolsillo() {
    }

    public Bolsillo(Long idBolsillo, Double saldo, String nombreBolsillo) {
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
    @JoinColumn(name = "cuenta_bancaria_id")
    private CuentaBancaria cuentaBancaria;
}
