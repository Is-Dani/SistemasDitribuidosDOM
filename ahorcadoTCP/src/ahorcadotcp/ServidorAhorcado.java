/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dani
 */
public class ServidorAhorcado {

    public static void main(String[] args) {
        JuegoAhorcado JA = new JuegoAhorcado();

        int port = 5001;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            while (true) {

                Socket client;
                PrintStream toClient;
                client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");

                char letra = fromClient.readLine().charAt(0);  // Recibimos la letra del cliente 

                String respuesta = JA.Jugar(letra);
                
//            System.out.println(fromClient.readLine());
                toClient = new PrintStream(client.getOutputStream());

                // Enviamos la respuesta al cliente
                toClient.println(respuesta);
                System.out.println("Cliente se conecto");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
