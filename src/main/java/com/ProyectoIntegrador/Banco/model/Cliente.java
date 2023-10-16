package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente_generator")
    @SequenceGenerator(name = "cliente_generator",allocationSize = 1)
    private long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "fechaNacimiento",nullable = false)
    private LocalDate fechaNacimiento;

    public Cliente(){
    }

    public Cliente(long id, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoContacto_id")
    private InfoContacto infoContacto;


    @OneToMany(mappedBy = "cliente")
    private List<CuentaBancaria> cuentas = new ArrayList<>();




}
