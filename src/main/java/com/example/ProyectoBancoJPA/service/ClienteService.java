package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.dto.ClienteDTO;

import java.util.Optional;

public interface ClienteService {
    Cliente createCliente(ClienteDTO clienteDTO) throws ApiRequestException;

    Iterable<Cliente> getAllClientes();

    Optional<Cliente> getClienteById(Integer id);

    Cliente updateCliente(Cliente clienteActualizado) throws ApiRequestException;

    void deleteCliente(Integer id);


}
