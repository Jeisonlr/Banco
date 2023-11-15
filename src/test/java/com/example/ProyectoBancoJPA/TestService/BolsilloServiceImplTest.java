package com.example.ProyectoBancoJPA.TestService;
import com.example.ProyectoBancoJPA.exceptions.BolsilloNoEncontradoException;
import com.example.ProyectoBancoJPA.exceptions.ClienteNoEncontradoException;
import com.example.ProyectoBancoJPA.model.Bolsillo;
import com.example.ProyectoBancoJPA.model.CuentaBancaria;
import com.example.ProyectoBancoJPA.repository.BolsilloRepository;
import com.example.ProyectoBancoJPA.repository.CuentaBancariaRepository;
import com.example.ProyectoBancoJPA.service.BolsilloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BolsilloServiceImplTest {

    @Mock
    private BolsilloRepository bolsilloRepository;

    @Mock
    private CuentaBancariaRepository cuentaBancariaRepository;

    @InjectMocks
    private BolsilloServiceImpl bolsilloService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBolsillo_ValidData_Success() {
        Bolsillo bolsillo = new Bolsillo();
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        bolsillo.setCuentaBancaria(cuentaBancaria);

        when(cuentaBancariaRepository.findById(any())).thenReturn(Optional.of(cuentaBancaria));
        when(bolsilloRepository.save(any())).thenReturn(bolsillo);

        Bolsillo result = bolsilloService.createBolsillo(bolsillo);

        assertNotNull(result);
        verify(bolsilloRepository, times(1)).save(any());
    }

    @Test
    void createBolsillo_InvalidData_ThrowsClienteNoEncontradoException() {
        Bolsillo bolsillo = new Bolsillo();

        when(cuentaBancariaRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ClienteNoEncontradoException.class, () -> {
            bolsilloService.createBolsillo(bolsillo);
        });

        verify(bolsilloRepository, never()).save(any());
    }

    @Test
    void getAllBolsillos_NoBolsillos_ReturnsEmptyList() {
        when(bolsilloRepository.findAll()).thenReturn(Collections.emptyList());

        List<Bolsillo> bolsillos = bolsilloService.getAllBolsillos();

        assertNotNull(bolsillos);
        assertTrue(bolsillos.isEmpty());
    }


    @Test
    void getBolsilloById_ExistingId_ReturnsBolsillo() {
        Bolsillo bolsillo = new Bolsillo();
        when(bolsilloRepository.findById(1)).thenReturn(Optional.of(bolsillo));

        Bolsillo result = bolsilloService.getBolsilloById(1);

        assertNotNull(result);
        assertEquals(bolsillo, result);
    }

    @Test
    void getBolsilloById_NonExistingId_ThrowsBolsilloNoEncontradoException() {
        when(bolsilloRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BolsilloNoEncontradoException.class, () -> {
            bolsilloService.getBolsilloById(1);
        });
    }


    @Test
    void updateBolsillo_ExistingId_ValidData_ReturnsUpdatedBolsillo() {
        Bolsillo bolsilloExistente = new Bolsillo();
        Bolsillo bolsilloActualizado = new Bolsillo();
        bolsilloActualizado.setSaldo(new BigDecimal(100.00));

        when(bolsilloRepository.findById(1)).thenReturn(Optional.of(bolsilloExistente));
        when(bolsilloRepository.save(any())).thenReturn(bolsilloExistente);

        Bolsillo result = bolsilloService.updateBolsillo(1, bolsilloActualizado);

        assertNotNull(result);
        assertEquals(bolsilloActualizado.getSaldo(), result.getSaldo());
        verify(bolsilloRepository, times(1)).save(any());
    }

    @Test
    void updateBolsillo_NonExistingId_ThrowsBolsilloNoEncontradoException() {
        when(bolsilloRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(BolsilloNoEncontradoException.class, () -> {
            bolsilloService.updateBolsillo(1, new Bolsillo());
        });

        verify(bolsilloRepository, never()).save(any());
    }

    @Test
    void deleteBolsillo_ExistingId_DeletesBolsillo() {
        when(bolsilloRepository.findById(anyInt())).thenReturn(Optional.of(new Bolsillo()));
        assertDoesNotThrow(() -> bolsilloService.deleteBolsillo(1));
    }

    @Test
    void deleteBolsillo_NonExistingId_ThrowsBolsilloNoEncontradoException() {
        when(bolsilloRepository.existsById(1)).thenReturn(false);

        assertThrows(BolsilloNoEncontradoException.class, () -> {
            bolsilloService.deleteBolsillo(1);
        });

        verify(bolsilloRepository, never()).deleteById(1);
    }

}
