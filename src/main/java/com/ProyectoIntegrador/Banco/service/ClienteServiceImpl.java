package com.ProyectoIntegrador.Banco.service;

import com.ProyectoIntegrador.Banco.model.Cliente;
import com.ProyectoIntegrador.Banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteByCedula(Long cedula) {
        return clienteRepository.findById(cedula);
    }

    @Override
    public Cliente updateCliente(Long cedula, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findById(cedula);

        if (clienteExistenteOptional.isPresent()) {
            Cliente clienteExistente = clienteExistenteOptional.get();

            // Actualiza los campos necesarios del cliente existente con los datos del cliente actualizado.
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());

            return clienteRepository.save(clienteExistente);
        } else {
            return null; // Manejo de error si el cliente no se encuentra.
        }
    }

    @Override
    public void deleteCliente(Long cedula) {
        clienteRepository.deleteById(cedula);
    }
}




