package com.ProyectoIntegrador.Banco;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

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
    @Column(name = "correo",nullable = false)
    private String correo;
    @Column(name = "ciudad")
    private String ciudad;

    public Cliente(){
    }

    public Cliente(long id, String nombre, String apellido, LocalDate fechaNacimiento, String correo, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", correo='" + correo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
