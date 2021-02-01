/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class clientUDP {
    // Los argumentos proporcionan el mensaje y el nombre del servidor

    public static void main(String args[]) {
        int puerto = 6789;
        Scanner sc = new Scanner(System.in);
        
        String result = "Seguir";
        byte letraB[] = null;
        try {
            while (true) {
                String ip = "localhost";
                DatagramSocket socketUDP = new DatagramSocket();

                System.out.println("Introduzca una letra");
                String letra = sc.next();

                //convertimos el dato a byte
                letraB = letra.getBytes();

                InetAddress hostServidor = InetAddress.getByName(ip);

                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion
                        = new DatagramPacket(letraB, letraB.length, hostServidor,
                                puerto);

                // Enviamos el datagrama
                socketUDP.send(peticion);

                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta
                        = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);

                // Enviamos la respuesta del servidor a la salida estandar

                // Cerramos el socket
                socketUDP.close();
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
