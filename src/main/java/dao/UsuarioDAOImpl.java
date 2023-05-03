package dao;

import interfaces.UsuarioDAO;
import model.Usuario.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl extends Conexion implements UsuarioDAO {
    @Override
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> listadoUsuarios = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("SELECT * FROM usuarios");

            ResultSet resultados = consulta.executeQuery();
            while (resultados.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(resultados.getInt("id_usuario"));
                usuario.setCorreo_eletronico(resultados.getString("correo_electronico"));
                usuario.setContrasena(resultados.getString("contrasena"));
                listadoUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return listadoUsuarios;
    }

    @Override
    public void registrar(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("INSERT INTO usuarios (correo_electronico, contrasena) VALUES (?, ?)");
            consulta.setString(1, usuario.getCorreo_eletronico());
            consulta.setString(2, usuario.getContrasena());
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("UPDATE usuarios SET correo_electronico = ? WHERE id_usuario = ?");
            consulta.setString(1, usuario.getCorreo_eletronico());
            consulta.setInt(2, usuario.getId_usuario());
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement consulta = this.conexion.prepareStatement("DELETE FROM usuarios WHERE id_usuario = ?");
            consulta.setInt(1, usuario.getId_usuario());
            consulta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void setConexion(IConexion conexion) {

    }
}
