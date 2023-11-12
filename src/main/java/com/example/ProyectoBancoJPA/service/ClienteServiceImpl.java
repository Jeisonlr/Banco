package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(ClienteDTO clienteDTO) throws ApiRequestException {
        Random random = new Random();
        Integer id = random.nextInt(1000);
        if(clienteDTO.getCedula() == null){
            throw new ApiRequestException("El Cliente debe tener una cédula");
        } else if(clienteRepository.existsByCedula(clienteDTO.getCedula())) {
            throw new ApiRequestException("La cédula Es Invalida. Ya se encuentra registrada");
        }
        if (clienteDTO.getNombre() == null) {
            throw new ApiRequestException("El cliente debe tener nombre");
        } else if (clienteDTO.getApellido() == null) {
            throw new ApiRequestException("El cliente debe tener apellido");
        }

        if (clienteDTO.getEdad() == null || clienteDTO.getEdad() <= 18) {
            throw new ApiRequestException("El cliente debe ser mayor a 18 años.");
        }

        Cliente cliente = new Cliente(id, clienteDTO.getCedula(), clienteDTO.getNombre(), clienteDTO.getApellido(), clienteDTO.getEdad(), null, null, null);
        return clienteRepository.save(cliente);
    }

    @Override
    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente updateCliente(Cliente clienteActualizado) throws ApiRequestException {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findById(clienteActualizado.getId());

        if (clienteExistenteOptional.isPresent()) {
            Cliente clienteExistente = clienteExistenteOptional.get();

            if (clienteActualizado.getNombre() == null || clienteActualizado.getApellido() == null) {
                throw new ApiRequestException("El nombre y el apellido no pueden ser nulos.");
            }

            if (clienteActualizado.getEdad() != null && clienteActualizado.getEdad() <= 18) {
                throw new ApiRequestException("La edad debe ser mayor a 18 años.");
            }

            if (clienteActualizado.getCorreo() != null && !clienteActualizado.getCorreo().contains("@")) {
                throw new ApiRequestException("El correo debe contener '@'.");
            }

            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setEdad(clienteActualizado.getEdad());
            clienteExistente.setCorreo(clienteActualizado.getCorreo());
            clienteExistente.setMunicipio(clienteActualizado.getMunicipio());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setEdad(clienteActualizado.getEdad());

            return clienteRepository.save(clienteExistente);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}




