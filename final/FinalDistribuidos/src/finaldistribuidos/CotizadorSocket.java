/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldistribuidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DANI
 */
public class CotizadorSocket {
     public static void main(String[] args) {
        int port = 5001; 

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); 
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            
            
            String cadena = fromClient.readLine();   //Leemos la Cadena que nos manda el cliente
            
            String respuesta = cotizacion(cadena);
            
//            System.out.println(fromClient.readLine());
            
            
            toClient = new PrintStream(client.getOutputStream()); 
            
            // Enviamos la respuesta al cliente
            toClient.println(respuesta);
            
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
     
     
     public static String cotizacion(String fecha){  
         return "7";
     }
     
}
