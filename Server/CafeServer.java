package Server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import Menu.BeverageRepository;

public class CafeServer {

    private static final String HOSTNAME = "localhost";
    private static final int PORT = 9000;
    private static final int BACKLOG = 1;

    static {
        BeverageRepository.getInstance().load();
    }

    public static void main(final String... args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        server.createContext("/Cafes", new CafeHandler());

        server.start();
    }
}
