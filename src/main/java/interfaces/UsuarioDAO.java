package interfaces;

import dao.CRUD;
import dao.IConexion;
import model.Usuario.Usuario;

public interface UsuarioDAO extends CRUD<Usuario> {
    void setConexion(IConexion conexion);
}
