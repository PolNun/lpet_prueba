package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection conexion;
    private final String URL_BBDD = "jdbc:postgresql://localhost:5432/lpet_prueba";
    private final String USUARIO = "soporte";
    private final String CONTRASENA = "soporte";

    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL_BBDD, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error al cerrar la conexión con la base de datos", e);
            }
        }
    }
}
