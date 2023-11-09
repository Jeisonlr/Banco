package com.ProyectoIntegrador.Banco.controller;

import com.ProyectoIntegrador.Banco.model.Cliente;
import com.ProyectoIntegrador.Banco.service.ClienteService;
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

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{cedula}")
    public Optional<Cliente> getClienteByCedula(@PathVariable Long cedula) {
        return clienteService.getClienteByCedula(cedula);
    }

  @PostMapping
  public Cliente crearCliente(@RequestBody Cliente cliente){
        return this.clienteService.createCliente(cliente);
  }
}


