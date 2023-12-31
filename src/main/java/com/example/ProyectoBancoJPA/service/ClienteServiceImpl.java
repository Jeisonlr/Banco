package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.exceptions.ClienteNoEncontradoException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
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
    public Cliente createCliente(Cliente cliente) throws ApiRequestException {
        Random random = new Random();
        Integer id = random.nextInt(10001);

        if(cliente.getNombre()==null){
            throw new ApiRequestException("El Cliente Debe Tener Un Nombre");
        }else if(cliente.getApellido()==null){
            throw new ApiRequestException("El Cliente Debe Tener Un Apellido");
        }else if(cliente.getCedula()==null){
            throw new ApiRequestException("El Cliente Debe Tener Una Cédula");
        }
        if (clienteRepository.existsByCedula(cliente.getCedula())) {
            throw new ApiRequestException("La Cédula Es Invalida.");
        }

        Cliente clienteEnviado = new Cliente(
                id,
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEdad(),
                cliente.getCorreo(),
                cliente.getMunicipio(),
                cliente.getTelefono());
        return clienteRepository.save(clienteEnviado);
    }

    @Override
    public Iterable<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException("No se encontró el cliente con ID: " + id));
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findById(id);

        if (clienteExistenteOptional.isPresent()) {
            Cliente clienteExistente = clienteExistenteOptional.get();
            clienteExistente.setCorreo(clienteActualizado.getCorreo());
            clienteExistente.setMunicipio(clienteActualizado.getMunicipio());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());

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




