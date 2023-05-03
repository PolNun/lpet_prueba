package http;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServidorLPET {

    public void crearServidor() {
        HttpServer server;
        // Crear una instancia de HttpServer en el puerto 8000
        try {
            // ELI5: la clase InetSocketAddress representa un par de direcciones IP y puerto. En este caso, el puerto es 8000. El 0 significa que el sistema operativo elegirá un puerto disponible.
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Asociar un manejador de solicitudes con el contexto localhost:8000"/usuarios"
        server.createContext("/usuarios", new ManejadorUsuarios());
        server.createContext("/eventos", new ManejadorEventos());

        // Arrancar el servidor
        server.start();
    }
}
