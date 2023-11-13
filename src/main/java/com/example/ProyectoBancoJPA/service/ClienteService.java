package com.example.ProyectoBancoJPA.service;
import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.dto.ClienteDTO;

public interface ClienteService {
    Cliente createCliente(Cliente cliente) throws ApiRequestException;

    Iterable<Cliente> getAllClientes();

    Cliente getClienteById(Integer id);

    Cliente updateCliente(Integer id, Cliente clienteActualizado);

    void deleteCliente(Integer id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

}
