package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary = "Obtener todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes recuperados exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping("/obtenerClientes")
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteService.getAllClientes();
    }

    @Operation(summary = "Obtener un cliente por cédula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente recuperado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        try {
            this.clienteService.createCliente(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (ApiRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


