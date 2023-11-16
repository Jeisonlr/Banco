package com.example.ProyectoBancoJPA.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaBancariaServiceImplTest {

    private CuentaBancariaRepository cuentaBancariaRepository;
    private ClienteRepository clienteRepository;
    private CuentaBancariaService cuentaBancariaService;

    @BeforeEach
    void setUp() {
        cuentaBancariaRepository = mock(CuentaBancariaRepository.class);
        clienteRepository = mock(ClienteRepository.class);
        cuentaBancariaService = new CuentaBancariaServiceImpl(cuentaBancariaRepository, clienteRepository);
    }

    @Test
    void testCreateCuentaBancaria() {
        // Arrange
        Cliente cliente = new Cliente();
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        cuentaBancaria.setCliente(cliente);
        cuentaBancaria.setBalance(new BigDecimal("25000"));

        when(clienteRepository.findById(any())).thenReturn(Optional.of(cliente));
        when(cuentaBancariaRepository.save(any())).thenReturn(cuentaBancaria);

        // Act
        CuentaBancaria result = cuentaBancariaService.createCuentaBancaria(cuentaBancaria);

        // Assert
        assertNotNull(result);
        assertEquals(cuentaBancaria, result);
    }

    @Test
    void testGetAllCuentasBancarias() {
        // Arrange
        List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
        when(cuentaBancariaRepository.findAll()).thenReturn(cuentasBancarias);

        // Act
        List<CuentaBancaria> result = cuentaBancariaService.getAllCuentasBancarias();

        // Assert
        assertNotNull(result);
        assertEquals(cuentasBancarias, result);
    }

    @Test
    void testGetCuentaBancariaById() {
        // Arrange
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        when(cuentaBancariaRepository.findById(any())).thenReturn(Optional.of(cuentaBancaria));

        // Act
        CuentaBancaria result = cuentaBancariaService.getCuentaBancariaById(1);

        // Assert
        assertNotNull(result);
        assertEquals(cuentaBancaria, result);
    }

    @Test
    void testUpdateCuentaBancaria() {
        // Arrange
        CuentaBancaria cuentaBancariaExistente = new CuentaBancaria();
        cuentaBancariaExistente.setIdCuenta(1);
        cuentaBancariaExistente.setBalance(new BigDecimal("10000"));

        CuentaBancaria cuentaBancariaActualizada = new CuentaBancaria();
        cuentaBancariaActualizada.setBalance(new BigDecimal("15000"));

        when(cuentaBancariaRepository.findById(1)).thenReturn(Optional.of(cuentaBancariaExistente));
        when(cuentaBancariaRepository.save(any())).thenReturn(cuentaBancariaExistente);

        // Act
        CuentaBancaria result = cuentaBancariaService.updateCuentaBancaria(1, cuentaBancariaActualizada);

        // Assert
        assertNotNull(result);
        assertEquals(cuentaBancariaActualizada.getBalance(), result.getBalance());
    }

    @Test
    void testDeleteCuentaBancaria() {
        // Arrange
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        cuentaBancaria.setIdCuenta(1);
        cuentaBancaria.setBalance(BigDecimal.ZERO);

        when(cuentaBancariaRepository.findById(1)).thenReturn(Optional.of(cuentaBancaria));
        doNothing().when(cuentaBancariaRepository).delete(any());

        // Act
        cuentaBancariaService.deleteCuentaBancaria(1);

    }
}

