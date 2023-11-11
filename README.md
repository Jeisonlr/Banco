# Proyecto Integrador - Gestión de bancos

Este repositorio contiene un proyecto integrador desarrollado como parte del bootcamp de Makaia. El proyecto se enfoca en la simulación de un sistema de transacciones bancarias utilizando una combinación de tecnologías, incluyendo Java, MySQL, Spring Boot, Spring Data, Spring Security, JWT, JUnit y Swagger.

### Equipo de trabajo:
* Jeison Rios
* Sofía Salamanca
* Nicolas Mahecha
* Leonardo Perdomo

## Contenido del Repositorio

- [Diagramas UML y Entidad-Relación](#diagramas-uml-y-entidad-relación)
- [Requisitos del Programa](#requisitos-del-programa)
- [Instrucciones de Ejecución](#instrucciones-de-ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)

## Diagramas UML y Entidad-Relación

A continuación, se presentan los diagramas UML que representan la estructura y relaciones del proyecto, así como el diagrama entidad-relación que ilustra la estructura de la base de datos utilizada:

<table>
  <tr>
    <td>
      <h3>Diagrama UML de Clases</h3>
      <img src="https://github.com/Jeisonlr/Banco/assets/74073693/205efaf0-c10c-458f-b586-e65f82e06e78" alt="Diagrama de Clases">
    </td>
    <td>
      <h3>Diagrama Entidad-Relación (ER)</h3>
      <img src="https://github.com/Jeisonlr/Banco/assets/74073693/f90fa8c6-9ae5-48c5-abb0-3bb5cb5830bf" alt="Diagrama Entidad-Relación">
    </td>
  </tr>
</table>

## Requisitos del Programa
Para ejecutar este programa de manera exitosa, es necesario tener las siguientes herramientas y tecnologías instaladas en su entorno de desarrollo:

- Java 17.
- MySQL Server (Puede utilizar MySQL Workbench).
- Spring Boot.
- Spring Security.
- JWT (JSON Web Tokens).
- JUnit (para pruebas unitarias).
- Swagger (opcional, para documentación de la API).

## Instrucciones de Ejecución

Siga los siguientes pasos para ejecutar el proyecto en su entorno local:

1. Clone este repositorio en su máquina local:

   ```bash
   git clone https://github.com/Jeisonlr/Banco.git
   
2. Configure la base de datos MySQL con las credenciales adecuadas.

3. Actualice la configuración de la base de datos en el archivo de propiedades de la aplicación (por ejemplo, application.properties o application.yml).

4. Compile y ejecute la aplicación Spring Boot.

5. Abra un navegador web y acceda a la documentación de la API a través de Swagger (si está habilitado).

## Estructura del Proyecto

Este proyecto sigue una estructura modularizada para facilitar la organización y mantenimiento del código. A continuación, se describe la jerarquía de carpetas y archivos en el directorio `src/main/java/com/example/ProyectoBancoJPA/`:

- **Auth/**
  - [`AuthResponse.java`](src/main/java/com/example/ProyectoBancoJPA/Auth/AuthResponse.java): Clase que representa la respuesta de autenticación.

- **Jwt/**
  - [`JwtAuthenticationFilter.java`](src/main/java/com/example/ProyectoBancoJPA/Jwt/JwtAuthenticationFilter.java): Filtro para procesar y validar tokens JWT en las solicitudes.
  - [`JwtService.java`](src/main/java/com/example/ProyectoBancoJPA/Jwt/JwtService.java): Servicio encargado de generar y validar tokens JWT.

- **Request/**
  - [`LoginRequest.java`](src/main/java/com/example/ProyectoBancoJPA/Request/LoginRequest.java): Clase que modela la solicitud de inicio de sesión.
  - [`RegisterRequest.java`](src/main/java/com/example/ProyectoBancoJPA/Request/RegisterRequest.java): Clase que modela la solicitud de registro.

- **config/**
  - [`ApplicationConfig.java`](src/main/java/com/example/ProyectoBancoJPA/config/ApplicationConfig.java): Configuración general de la aplicación.
  - [`SecurityConfig.java`](src/main/java/com/example/ProyectoBancoJPA/config/SecurityConfig.java): Configuración de seguridad, incluyendo la configuración de Spring Security.

- **controller/**
  - [`AuthController.java`](src/main/java/com/example/ProyectoBancoJPA/controller/AuthController.java): Controlador que maneja las operaciones relacionadas con la autenticación.
  - [`BolsilloController.java`](src/main/java/com/example/ProyectoBancoJPA/controller/BolsilloController.java): Controlador para operaciones relacionadas con bolsillos.
  - [`ClienteController.java`](src/main/java/com/example/ProyectoBancoJPA/controller/ClienteController.java): Controlador para operaciones relacionadas con clientes.
  - [`CuentaBancariaController.java`](src/main/java/com/example/ProyectoBancoJPA/controller/CuentaBancariaController.java): Controlador para operaciones relacionadas con cuentas bancarias.
  - [`TransaccionController.java`](src/main/java/com/example/ProyectoBancoJPA/controller/TransaccionController.java): Controlador para operaciones relacionadas con transacciones.

- **dto/**
  - [`BolsilloDTO.java`](src/main/java/com/example/ProyectoBancoJPA/dto/BolsilloDTO.java): Objeto de transferencia de datos (DTO) para la entidad Bolsillo.
  - [`ClienteDTO.java`](src/main/java/com/example/ProyectoBancoJPA/dto/ClienteDTO.java): DTO para la entidad Cliente.
  - [`CuentaBancariaDTO.java`](src/main/java/com/example/ProyectoBancoJPA/dto/CuentaBancariaDTO.java): DTO para la entidad Cuenta Bancaria.
  - [`TransaccionDTO.java`](src/main/java/com/example/ProyectoBancoJPA/dto/TransaccionDTO.java): DTO para la entidad Transacción.
  - [`TransferenciaExternaRequest.java`](src/main/java/com/example/ProyectoBancoJPA/dto/TransferenciaExternaRequest.java): DTO para solicitudes de transferencias externas.
  - [`TransferenciaInternaRequest.java`](src/main/java/com/example/ProyectoBancoJPA/dto/TransferenciaInternaRequest.java): DTO para solicitudes de transferencias internas.

- **exceptions/**
  - [`BolsilloNoEncontradoException.java`](src/main/java/com/example/ProyectoBancoJPA/exceptions/BolsilloNoEncontradoException.java): Excepción lanzada cuando no se encuentra un bolsillo.
  - [`ClienteNotFoundException.java`](src/main/java/com/example/ProyectoBancoJPA/exceptions/ClienteNotFoundException.java): Excepción lanzada cuando no se encuentra un cliente.
  - [`CuentaNoEncontradaException.java`](src/main/java/com/example/ProyectoBancoJPA/exceptions/CuentaNoEncontradaException.java): Excepción lanzada cuando no se encuentra una cuenta bancaria.
  - [`SaldoInsuficienteException.java`](src/main/java/com/example/ProyectoBancoJPA/exceptions/SaldoInsuficienteException.java): Excepción lanzada cuando hay un intento de transacción con saldo insuficiente.

- **model/**
  - [`Bolsillo.java`](src/main/java/com/example/ProyectoBancoJPA/model/Bolsillo.java): Clase que representa la entidad Bolsillo.
  - [`Cliente.java`](src/main/java/com/example/ProyectoBancoJPA/model/Cliente.java): Clase que representa la entidad Cliente.
  - [`CuentaBancaria.java`](src/main/java/com/example/ProyectoBancoJPA/model/CuentaBancaria.java): Clase que representa la entidad Cuenta Bancaria.
  - [`Transaccion.java`](src/main/java/com/example/ProyectoBancoJPA/model/Transaccion.java): Clase que representa la entidad Transacción.

- **repository/**
  - [`BolsilloRepository.java`](src/main/java/com/example/ProyectoBancoJPA/repository/BolsilloRepository.java): Interfaz para acceder y manipular datos de Bolsillos en la base de datos.
  - [`ClienteRepository.java`](src/main/java/com/example/ProyectoBancoJPA/repository/ClienteRepository.java): Interfaz para acceder y manipular datos de Clientes en la base de datos.
  - [`CuentaBancariaRepository.java`](src/main/java/com/example/ProyectoBancoJPA/repository/CuentaBancariaRepository.java): Interfaz para acceder y manipular datos de Cuentas Bancarias en la base de datos.
  - [`TransaccionRepository.java`](src/main/java/com/example/ProyectoBancoJPA/repository/TransaccionRepository.java): Interfaz para acceder y manipular datos de Transacciones en la base de datos.
  - [`TransaccionRepositoryImpl.java`](src/main/java/com/example/ProyectoBancoJPA/repository/TransaccionRepositoryImpl.java): Implementación personalizada de TransaccionRepository para operaciones específicas.
  - [`UserRepository.java`](src/main/java/com/example/ProyectoBancoJPA/repository/UserRepository.java): Interfaz para acceder y manipular datos de Usuarios en la base de datos.

- **service/**
  - [`AuthService.java`](src/main/java/com/example/ProyectoBancoJPA/service/AuthService.java): Interfaz que define operaciones relacionadas con la autenticación.
  - [`BolsilloService.java`](src/main/java/com/example/ProyectoBancoJPA/service/BolsilloService.java): Interfaz que define operaciones relacionadas con Bolsillos.
  - [`BolsilloServiceImpl.java`](src/main/java/com/example/ProyectoBancoJPA/service/BolsilloServiceImpl.java): Implementación de BolsilloService.
  - [`ClienteService.java`](src/main/java/com/example/ProyectoBancoJPA/service/ClienteService.java): Interfaz con la definición de los métodos relacionados a los clientes
  - [`ClienteServiceImpl.java`](src/main/java/com/example/ProyectoBancoJPA/service/ClienteServiceImpl.java): Implementación de ClienteService.
  - [`CuentaBancariaService.java`](src/main/java/com/example/ProyectoBancoJPA/service/CuentaBancariaService.java): Interfaz que define operaciones relacionadas con Cuentas Bancarias.
  - [`CuentaBancariaServiceImpl.java`](src/main/java/com/example/ProyectoBancoJPA/service/CuentaBancariaServiceImpl.java): Implementación de CuentaBancariaService.
  - [`TransaccionService.java`](src/main/java/com/example/ProyectoBancoJPA/service/TransaccionService.java): Interfaz que define operaciones relacionadas con Transacciones.

- **user/**
  - [`Role.java`](src/main/java/com/example/ProyectoBancoJPA/user/Role.java): Clase que representa los roles de usuario.
  - [`User.java`](src/main/java/com/example/ProyectoBancoJPA/user/User.java): Clase que representa a los usuarios del sistema.

* Otros archivos y directorios de configuración, como application.properties.

Este proyecto sigue las mejores prácticas de desarrollo de Spring Boot y se enfoca en la seguridad y la gestión de transacciones bancarias. 




