package dao;

import java.util.List;

public interface CRUD<T> {
    List<T> listarTodos() throws Exception;

    void registrar(T t) throws Exception;

    void actualizar(T t) throws Exception;

    void eliminar(T t) throws Exception;
}
