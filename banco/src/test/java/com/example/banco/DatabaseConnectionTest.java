package com.example.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/proyecto_sistemabancario";
        String username = "root";
        String password = "carlina1234*";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexión exitosa a la base de datos.");
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
