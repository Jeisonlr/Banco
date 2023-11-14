package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClienteServiceImplTest {

    ClienteServiceImpl clienteServiceImpl;

    ClienteRepository clienteRepository;
    private Cliente cliente;

    @BeforeAll
    public void setUp() {
        cliente = new Cliente(1, "123", "manuel", "ospina", 28, "ZXC@GMAIL.COM", "Medellin", "7895623");
        clienteRepository = mock(ClienteRepository.class);
        when(clienteRepository.save(any(Cliente.class))).thenAnswer(invocation -> {
            Cliente clienteGuardado = invocation.getArgument(0);
            return clienteGuardado;
        });

        clienteServiceImpl = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    public void crearCliente() throws ApiRequestException {

        Cliente clienteCreado = this.clienteServiceImpl.createCliente(cliente);

        assertNotNull(clienteCreado, "El cliente creado no debería ser nulo");

        assertEquals("123", clienteCreado.getCedula(), "Cédula incorrecta");
        assertEquals("manuel", clienteCreado.getNombre(), "Nombre incorrecto");
        assertEquals("ospina", clienteCreado.getApellido(), "Apellido incorrecto");
        assertEquals(28, clienteCreado.getEdad(), "Edad incorrecta");
    }


    @Test
    void crearClienteSinCedula() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImpl.createCliente(cliente);
        cliente.setCedula(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImpl.createCliente(cliente));

    }

    @Test
    void crearClienteSinNombre() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImpl.createCliente(cliente);
        cliente.setNombre(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImpl.createCliente(cliente));
    }

    @Test
    void crearClienteSinApellido() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImpl.createCliente(cliente);
        cliente.setApellido(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImpl.createCliente(cliente));
    }

    @Test
    void crearClienteSinEdad() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImpl.createCliente(cliente);
        cliente.setEdad(null);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImpl.createCliente(cliente));
    }

}