package model.Usuario;

public class Usuario {
    private int id_usuario;
    private String correo_eletronico;
    private String contrasena;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo_eletronico() {
        return correo_eletronico;
    }

    public void setCorreo_eletronico(String correo_eletronico) {
        this.correo_eletronico = correo_eletronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "correo_eletronico: '" + correo_eletronico + '\'' +
                ", contrasena: '" + contrasena + '\'' +
                '}';
    }
}