/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumatcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos
 */
public class ServidorSuma {

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
            
            String cadena = fromClient.readLine();
            String respuesta = suma(cadena);
            
//            System.out.println(fromClient.readLine());
            
            
            toClient = new PrintStream(client.getOutputStream()); 
            
            // Enviamos la respuesta al cliente
            toClient.println(respuesta);
            
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    //funcion que realiza la suma... recibe la cadena...ej. 3,4  [3,4]
    public static String suma(String num){
        String r ="";
        String[] numeros = num.split(","); // funcion que separa un String por un indicador en este caso "," y lo convierte en un vector
        r = String.valueOf(Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]));  
        return r;
    }
}
