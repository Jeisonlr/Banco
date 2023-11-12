package com.example.ProyectoBancoJPA.dto;


public class ClienteDTO {
    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Integer edad;

    public ClienteDTO(String cedula, String nombre, String apellido, Integer edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getCedula() {
        return cedula;
    }
}
