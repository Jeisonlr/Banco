package com.example.ProyectoBancoJPA.exceptions;

public class CuentaNoEncontradaException extends RuntimeException {

    public CuentaNoEncontradaException(String mensaje) {
        super("La cuenta no existe");
    }
}