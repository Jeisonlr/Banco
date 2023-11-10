package com.example.ProyectoBancoJPA.controller;

import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.service.BolsilloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolsillos")
public class BolsilloController {
    private final BolsilloService bolsilloService;

    @Autowired
    public BolsilloController(BolsilloService bolsilloService) {
        this.bolsilloService = bolsilloService;
    }

    @Operation(summary = "Obtener todos los bolsillos de una cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bolsillos encontrados correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bolsillo.class)) }),
            @ApiResponse(responseCode = "400", description = "Id invalidad",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cuenta bancaria no encontrada",
                    content = @Content)})
    @GetMapping("/{id}")
    public Bolsillo getBolsilloById(@PathVariable Integer id) {
        return bolsilloService.getBolsilloById(id);
    }

    @PostMapping
    public Bolsillo crearBolsillo(@RequestBody Bolsillo bolsillo){
        return this.bolsilloService.createBolsillo(bolsillo);
    }
}
