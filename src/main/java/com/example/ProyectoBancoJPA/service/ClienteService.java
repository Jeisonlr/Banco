package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.dto.ClienteDTO;
import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    Cliente createCliente(Cliente cliente) throws ApiRequestException;

    Iterable<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente updateCliente(Integer id, Cliente clienteActualizado);

    void deleteCliente(Integer id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

}
