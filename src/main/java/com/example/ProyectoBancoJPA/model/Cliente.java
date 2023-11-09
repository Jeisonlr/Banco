package com.example.ProyectoBancoJPA.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cedula", nullable = false)
    private String cedula;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "edad",nullable = false)
    private Integer edad;
    @Column(name = "correo",nullable = false)
    private String correo;
    @Column(name = "municipio",nullable = false)
    private String municipio;
    @Column(name = "telefono",nullable = false)
    private String telefono;

    public Cliente(){
    }

    public Cliente(Integer id, String cedula, String nombre, String apellido, Integer edad, String correo, String municipio, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.municipio = municipio;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }


    @OneToMany(mappedBy = "cliente")
    private List<CuentaBancaria> cuentasBancarias = new ArrayList<>();

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
