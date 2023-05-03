package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dao.UsuarioDAOImpl;
import interfaces.UsuarioDAO;

import java.io.IOException;

public class ManejadorUsuarios implements HttpHandler {
    String respuesta = "";

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Obtener la solicitud del cliente
        String requestMethod = exchange.getRequestMethod();

        switch (requestMethod) {
            case "GET":
                manejadorPeticionGET(exchange);
                break;
            case "POST":
                manejadorPeticionPOST(exchange);
                break;
            case "PUT":
                manejadorPeticionPUT(exchange);
                break;
            case "DELETE":
                manejadorPeticionDELETE(exchange);
                break;
            default:
                manejadorError(exchange);
        }
    }

    private void manejadorError(HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(405, -1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void manejadorPeticionGET(HttpExchange exchange) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            respuesta = usuarioDAO.listarTodos().toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Enviar la respuesta al cliente
        try {
            exchange.sendResponseHeaders(200, respuesta.length());
            exchange.getResponseBody().write(respuesta.getBytes());
            exchange.getResponseBody().close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void manejadorPeticionPOST(HttpExchange exchange) {

    }

    private void manejadorPeticionPUT(HttpExchange exchange) {
    }

    private void manejadorPeticionDELETE(HttpExchange exchange) {
    }
}
