package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente createCliente(Cliente cliente);

    List<Cliente> getAllClientes();

    Optional<Cliente> getClienteByCedula(Long cedula);

    Cliente updateCliente(Long cedula, Cliente clienteActualizado);

    void deleteCliente(Long cedula);

}
