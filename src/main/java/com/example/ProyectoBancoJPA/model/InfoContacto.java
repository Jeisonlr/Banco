package com.example.ProyectoBancoJPA.model;


import jakarta.persistence.*;

@Entity
@Table(name = "infoContacto")
public class InfoContacto {
    @Id
    @Column
    private Integer id;
    @Column(name = "correo",nullable = false)
    private String correo;
    @Column(name = "municipio",nullable = false)
    private String municipio;
    @Column(name = "departamento",nullable = false)
    private String departamento;
    @Column(name = "direccion",nullable = false)
    private String direccion;
    @Column(name = "telefono",nullable = false)
    private String telefono;

    @OneToOne(mappedBy = "infoContacto")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public InfoContacto() {
    }

    public InfoContacto(Integer id, String correo, String municipio, String departamento, String direccion, String telefono, Cliente cliente) {
        this.id = id;
        this.correo = correo;
        this.municipio = municipio;
        this.departamento = departamento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "InfoContacto{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", municipio='" + municipio + '\'' +
                ", departamento='" + departamento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
