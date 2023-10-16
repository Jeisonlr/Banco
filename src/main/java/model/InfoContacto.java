package model;


import jakarta.persistence.*;
import model.Cliente;

@Entity
@Table(name = "infoContacto")
public class InfoContacto {
    @Id
    @Column
    private Long id;
    @Column(name = "correo",nullable = false)
    private String correo;
    @Column(name = "municipio",nullable = false)
    private String municipio;
    @Column(name = "departamento",nullable = false)
    private String departamento;
    @Column(name = "telefono",nullable = false)
    private String telefono;
    @Column(name = "direccion",nullable = false)
    private String direccion;

    @OneToOne(mappedBy = "infoContacto")
    private Cliente cliente;
}
