package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.dto.TransferenciaExternaRequest;
import com.example.ProyectoBancoJPA.dto.TransferenciaInternaRequest;
import com.example.ProyectoBancoJPA.exceptions.SaldoInsuficienteException;
import com.example.ProyectoBancoJPA.model.Transaccion;
import com.example.ProyectoBancoJPA.service.TransaccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    private TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @Operation(summary = "Obtener todas las transacciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de transacciones recuperadas exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaccion.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping
    public Iterable<Transaccion> getAllTransacciones() {
        return transaccionService.getAllTransacciones();
    }

    @Operation(summary = "Obtener una transacción por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción recuperada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaccion.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping("/{id}")
    public Transaccion getTransaccionById(@PathVariable Integer id) {
        return transaccionService.getTransaccionById(id);
    }

    @Operation(summary = "Actualizar una transacción por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transacción actualizada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaccion.class))),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PutMapping("/{id}")
    public Transaccion updateTransaccion(@PathVariable Integer id, @RequestBody Transaccion updatedTransaccion) {
        return transaccionService.updateTransaccion(id, updatedTransaccion);
    }

    @Operation(summary = "Eliminar una transacción por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transacción eliminada exitosamente",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Transacción no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public void deleteTransaccion(@PathVariable Integer id) {
        transaccionService.deleteTransaccion(id);
    }

    @Operation(summary = "Realizar transferencia interna")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transferencia interna realizada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaccion.class))),
            @ApiResponse(responseCode = "400", description = "Saldo insuficiente",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PostMapping("/transferencia-interna")
    public ResponseEntity<Transaccion> realizarTransferenciaInterna(
            @RequestBody TransferenciaInternaRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarTransferenciaInterna(
                    request.getCuenta(),
                    request.getBolsillo(),
                    request.getMonto()
            );
            return new ResponseEntity<>(transaccion, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Realizar transferencia externa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transferencia externa realizada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Transaccion.class))),
            @ApiResponse(responseCode = "400", description = "Saldo insuficiente",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PostMapping("/transferencia-externa")
    public ResponseEntity<Transaccion> realizarTransferenciaExterna(
            @RequestBody TransferenciaExternaRequest request) {
        try {
            Transaccion transaccion = transaccionService.realizarTransferenciaExterna(
                    request.getCuentaOrigen(),
                    request.getCuentaDestino(),
                    request.getMonto()
            );
            return new ResponseEntity<>(transaccion, HttpStatus.CREATED);
        } catch (SaldoInsuficienteException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
