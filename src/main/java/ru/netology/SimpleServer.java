package ru.netology;

import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 8080; // Порт сервера

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            Socket clientSocket = serverSocket.accept(); // Ждем подключения клиента
            System.out.println("New connection accepted from port " + clientSocket.getPort());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Reading message from client...");
            String message = in.readLine();
            System.out.println("Message received from client: " + message);

            out.println(String.format("Hi %s, your port is %d", message, clientSocket.getPort()));

        } catch (IOException e) {
            System.err.println("Error in the server: " + e.getMessage());
        }
    }
}
