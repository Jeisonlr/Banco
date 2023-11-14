package com.example.ProyectoBancoJPA.service;

import com.example.ProyectoBancoJPA.exceptions.ApiRequestException;
import com.example.ProyectoBancoJPA.exceptions.ClienteNoEncontradoException;
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
import static org.mockito.Mockito.*;

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
    void crearClienteSinEdadCorrecta() throws ApiRequestException {

        Cliente clienteGuardado = this.clienteServiceImpl.createCliente(cliente);
        cliente.setEdad(14);

        ApiRequestException excepcion = assertThrows(ApiRequestException.class,
                () -> clienteServiceImpl.createCliente(cliente));
    }
    @Test
    void getAllClientes() {
        // Configuración del repositorio para devolver una lista de clientes
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));

        // Llamada al método
        Iterable<Cliente> clientes = clienteServiceImpl.getAllClientes();

        // Verificación de la lista de clientes
        assertNotNull(clientes);
        assertTrue(clientes.iterator().hasNext());
    }



    @Test
    void getClienteByIdNoExistente() {
        // Configuración del repositorio para devolver un cliente vacío
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());

        // Llamada al método y manejo de la excepción
        ClienteNoEncontradoException excepcion = assertThrows(ClienteNoEncontradoException.class,
                () -> clienteServiceImpl.getClienteById(2));
    }


    @Test
    void updateClienteNoExistente() {
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());
        Cliente clienteModificado = clienteServiceImpl.updateCliente(2, new Cliente());
        assertNull(clienteModificado);
    }

    @Test
    void deleteCliente() {
        clienteServiceImpl.deleteCliente(1);
        verify(clienteRepository, times(1)).deleteById(1);
    }

}