package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.dto.ClienteDTO;

import java.util.Optional;

public interface ClienteService {
    Cliente createCliente(Cliente cliente);

    Iterable<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente updateCliente(Integer id, Cliente clienteActualizado);

    void deleteCliente(Integer id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

}