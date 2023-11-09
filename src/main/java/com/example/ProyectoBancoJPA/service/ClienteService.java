package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.dto.ClienteDTO;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Random random = new Random();
        Integer id = random.nextInt(10001);
        Cliente cliente = new Cliente(
                id,
                clienteDTO.getCedula(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido(),
                clienteDTO.getEdad(),
                null,
                null,
                null);
        this.clienteRepository.save(cliente);
        return clienteDTO;
    }

    public Cliente completarInfo(Integer id, String correo, String municipio, String telefono) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setCorreo(correo);
            cliente.setMunicipio(municipio);
            cliente.setTelefono(telefono);

            clienteRepository.save(cliente);

            return cliente;
        } else {
            return null; // hacer exception
        }
    }

}
