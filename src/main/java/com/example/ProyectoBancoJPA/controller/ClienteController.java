package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Api(value = "Clientes", description = "Controladores asociados a los clientes")
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
        return clienteService.getClienteById(cedula);
    }

    @PostMapping ("/create")
    @ApiOperation(value = "Crear un cliente", response = Cliente.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "El cliente ha sido creado exitosamente", response = Cliente.class),
            @ApiResponse(code = 400, message = "La solicitued es incorrecta", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Error interno del servidor", response = ErrorResponse.class)
    })
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return this.clienteService.createCliente(cliente);
    }
}


