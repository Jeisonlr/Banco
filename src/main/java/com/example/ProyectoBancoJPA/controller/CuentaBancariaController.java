package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.exceptions.CuentaNoEncontradaException;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.service.CuentaBancariaService;
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

@RestController
@RequestMapping("/cuentas")
public class CuentaBancariaController {
    private final CuentaBancariaService cuentaBancariaService;

    @Autowired
    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @Operation(summary = "Obtener todas las cuentas bancarias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cuentas bancarias recuperadas exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaBancaria.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping("/get-all")
    public List<CuentaBancaria> getAllCuentasBancarias() {
        return cuentaBancariaService.getAllCuentasBancarias();
    }

    @Operation(summary = "Obtener una cuenta bancaria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta bancaria recuperada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaBancaria.class))),
            @ApiResponse(responseCode = "404", description = "Cuenta bancaria no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @GetMapping("/get/{id}")
    public ResponseEntity<CuentaBancaria> getCuentaBancariaById(@PathVariable Integer idCuenta) {
        try {
            CuentaBancaria cuenta = cuentaBancariaService.getCuentaBancariaById(idCuenta);
            return new ResponseEntity<>(cuenta, HttpStatus.OK);
        } catch (CuentaNoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Crear una nueva cuenta bancaria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cuenta bancaria creada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaBancaria.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PostMapping("/create")
    public ResponseEntity<CuentaBancaria> createCuentaBancaria(@RequestBody CuentaBancaria cuentaBancaria) {
        CuentaBancaria nuevaCuenta = this.cuentaBancariaService.createCuentaBancaria(cuentaBancaria);
        return new ResponseEntity<>(nuevaCuenta, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una cuenta bancaria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta bancaria actualizada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaBancaria.class))),
            @ApiResponse(responseCode = "404", description = "Cuenta bancaria no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)})
    @PutMapping("/update/{id}")
    public ResponseEntity<CuentaBancaria> updateCuentaBancaria(
            @PathVariable Integer id,
            @RequestBody CuentaBancaria cuentaBancariaActualizada) {
        try {
            CuentaBancaria cuentaActualizada = cuentaBancariaService.updateCuentaBancaria(id, cuentaBancariaActualizada);
            return new ResponseEntity<>(cuentaActualizada, HttpStatus.OK);
        } catch (CuentaNoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}




