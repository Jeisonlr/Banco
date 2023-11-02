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

- Java 8 o superior.
- MySQL Server.
- Spring Boot.
- Spring Data.
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
El proyecto está estructurado de la siguiente manera:
* `src/main/java/com/ProyectoIntegrador/Banco`: Contiene los archivos principales del programa:
  * `model:`: En este paquete, se encuentran las entidades del dominio del sistema, que representan los conceptos clave del negocio. Las entidades incluyen:
    * `Bolsillo`: Representa un objeto que almacena dinero de un cliente, generalmente asociado a una cuenta bancaria.
    * `CuentaBancaria`: Representa una cuenta bancaria que pertenece a un cliente, donde se realizan las transacciones financieras.
    * `InfoContacto`: Contiene información de contacto de un cliente, como dirección, teléfono, correo electrónico, etc.
    * `Transaccion`: Representa una transacción financiera entre cuentas bancarias, registrando detalles como el monto, la fecha y la descripción.
    * `Cliente`: Representa a un cliente del banco y contiene información personal, incluyendo información de contacto y las cuentas bancarias asociadas.
  * `controllers`: En este paquete, se encuentran los controladores de la aplicación que manejan las solicitudes HTTP y definen las rutas de la API.
  * `services:`: Aquí se encuentran los servicios que implementan la lógica de negocio y gestionan la interacción con las entidades y los controladores.
  * `repositories`: Contiene los repositorios que se utilizan para acceder y gestionar la persistencia de los datos en la base de datos. Cada entidad generalmente tiene su propio repositorio para realizar operaciones de lectura y escritura.
* `resources`: Contiene archivos de configuración y recursos estáticos.
* `test`: Contiene pruebas unitarias y de integración.
* `pom.xml`: Archivo de configuración de Maven que define las dependencias del proyecto.

* Otros archivos y directorios de configuración, como application.properties.

Este proyecto sigue las mejores prácticas de desarrollo de Spring Boot y se enfoca en la seguridad y la gestión de transacciones bancarias. 




