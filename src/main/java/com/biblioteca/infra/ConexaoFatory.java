package com.biblioteca.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFatory {
    private static final String USUARIO = "root";
    private static final String SENHA = "Alvaro3002";
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados ", e);
        }

    }
}
