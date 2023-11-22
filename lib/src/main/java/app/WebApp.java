package app;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class WebApp {
    public static final int Porta = 8080;

    public static void main(String[] args) {
        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(Porta), 0);

            servidor.createContext("/", new WebAppHandler());

            servidor.setExecutor(null);

            System.out.printf("Servidor web inicializado na porta %d%n", Porta);

            servidor.start();
        } catch (IOException e) {
            System.out.printf("Ocorreu uma falha no servidor web na porta %d%n", Porta);

            e.printStackTrace();
        }
    }
}
