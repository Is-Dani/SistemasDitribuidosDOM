/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmilaboratorio;

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
public class ServidorBancoCliente {
    
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
            
            String respuesta = verificarSaldo(cadena);
            
//            System.out.println(fromClient.readLine());
            
            
            toClient = new PrintStream(client.getOutputStream()); 
            
            // Enviamos la respuesta al cliente
            toClient.println(respuesta);
            
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
     
     
     public static String verificarSaldo(String cadena){  //3,210
        String[] array = cadena.split(","); //[3,210]
        String idcliente = array[0]; //3
        double monto = Double.parseDouble(array[1]); //210
         
        String retorno="0";
        
        switch(idcliente){
            case "1":
                if(300-monto>=0){
                    retorno = "1";
                }
            break;
            
            case "2":
                if(400-monto>=0){
                    retorno = "1";
                }
            break;
            
            case "3":
                if(1000-monto>=0){
                    retorno = "1";
                }
            break;
        }
        return retorno;
     }
     
}
