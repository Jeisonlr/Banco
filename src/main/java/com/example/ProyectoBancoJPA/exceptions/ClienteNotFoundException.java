package com.example.ProyectoBancoJPA.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException() {
        super("Cliente no encontrado");
    }
}

