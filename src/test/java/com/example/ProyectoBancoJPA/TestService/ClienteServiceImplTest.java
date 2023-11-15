package com.example.ProyectoBancoJPA.TestService;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.model.Cliente;
import com.example.ProyectoBancoJPA.repository.ClienteRepository;
import com.example.ProyectoBancoJPA.service.ClienteServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClienteServiceImplTest {

    ClienteServiceImpl clienteServiceImpl;

    ClienteRepository clienteRepository;

    @BeforeAll
    public void setUp() {
        clienteRepository = mock(ClienteRepository.class);
        when(clienteRepository.save(any(Cliente.class))).thenAnswer(invocation -> {
            Cliente clienteGuardado = invocation.getArgument(0);
            return clienteGuardado;
        });

        clienteServiceImpl = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    public void crearCliente() throws ApiRequestException {
        Cliente cliente = new Cliente(1, "123", "manuel", "ospina", 28, "ZXC@GMAIL.COM", "Medellin", "7895623");
        Cliente clienteCreado = this.clienteServiceImpl.createCliente(cliente);

        assertNotNull(clienteCreado, "El cliente creado no debería ser nulo");

        assertEquals("123", clienteCreado.getCedula(), "Cédula incorrecta");
        assertEquals("manuel", clienteCreado.getNombre(), "Nombre incorrecto");
        assertEquals("ospina", clienteCreado.getApellido(), "Apellido incorrecto");
        assertEquals(28, clienteCreado.getEdad(), "Edad incorrecta");
    }
}
