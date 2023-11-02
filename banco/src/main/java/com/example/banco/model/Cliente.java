package com.example.banco.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "fechaNacimiento",nullable = false)
    private Date fechaNacimiento;
    @Column(name = "estado_civil")
    private String estado_civil;
    @Column(name = "ocupacion")
    private String ocupacion;
    @Column(name = "correo",nullable = false)
    private String correo;
    @Column(name = "ciudad",nullable = false)
    private String municipio;
    @Column(name = "pais",nullable = false)
    private String pais;
    public Cliente(){
    }

    public Cliente(Integer id, String nombre, String apellido, Date fechaNacimiento, String estado_civil, String ocupacion, String correo, String municipio, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.estado_civil = estado_civil;
        this.ocupacion = ocupacion;
        this.correo = correo;
        this.municipio = municipio;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", estado_civil='" + estado_civil + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", correo='" + correo + '\'' +
                ", municipio='" + municipio + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
