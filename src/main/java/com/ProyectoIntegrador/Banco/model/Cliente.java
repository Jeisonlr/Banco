package com.ProyectoIntegrador.Banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "fechaNacimiento",nullable = false)
    private LocalDate fechaNacimiento;


    @OneToMany(mappedBy = "cliente")
    private List<CuentaBancaria> cuentas = new ArrayList<>();




}
/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "infoContacto_id")
    private InfoContacto infoContacto;
*/
