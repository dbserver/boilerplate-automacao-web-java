package app;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import framework.utils.FileOperations;

public class WebApp {
    public static final int Porta = Integer.parseInt(
            FileOperations.getProperties("website_config").getProperty("porta"));

    public static void main(String[] args) {
        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(WebApp.Porta), 0);

            servidor.createContext("/", new WebAppHandler());

            servidor.setExecutor(null);

            System.out.printf("Servidor web inicializado na porta %d%n", WebApp.Porta);

            servidor.start();
        } catch (IOException e) {
            System.out.printf("Ocorreu uma falha no servidor web na porta %d%n", WebApp.Porta);

            e.printStackTrace();
        }
    }
}
