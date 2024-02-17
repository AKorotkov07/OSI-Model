package ru.netology;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello, server! This is the client.");

            String response = in.readLine();
            System.out.println("Response from server: " + response);

        } catch (IOException e) {
            System.err.println("Error in the client: " + e.getMessage());
        }
    }
}
