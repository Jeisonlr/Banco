package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/obtenerClientes")
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteService.getAllClientes();
    }

    @GetMapping("/{cedula}")
    public Optional<Cliente> getClienteByCedula(@PathVariable Integer cedula) {
        return Optional.ofNullable(clienteService.getClienteById(cedula));
    }

    @PostMapping ("/create")
    public Cliente crearCliente(@RequestBody Cliente cliente) throws ApiRequestException {
        return this.clienteService.createCliente(cliente);
    }
}


