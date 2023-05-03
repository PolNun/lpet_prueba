import http.ServidorLPET;

public class App {
    public static void main(String[] args) {
//        try {
//            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
//            usuarioDAO.listarTodos().forEach(System.out::println);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        ServidorLPET servidorLPET = new ServidorLPET();

        servidorLPET.crearServidor();
    }
}
