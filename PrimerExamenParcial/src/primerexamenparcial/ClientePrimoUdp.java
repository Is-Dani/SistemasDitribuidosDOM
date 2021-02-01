/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Dani
 */
public class ClientePrimoUdp {
    // Los argumentos proporcionan el mensaje y el nombre del servidor
    public static void main(String args[]) {
        int puerto = 6789;

        try {
            int dato = 25;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();

            //convertimos el dato a byte
            byte numero = (byte) dato;
            //convetimor numero de byte a array Byte
            byte[] mensaje = new byte[1];
            mensaje[0] = numero;

            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion
                    = new DatagramPacket(mensaje, mensaje.length, hostServidor, puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta
                    = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            byte[] resp = respuesta.getData();
            String r;
            if (resp[0] == 2){
                r = "no es primo";
            }else{
                r = "es primo";
            }
            System.out.println("Respuesta: " + r);
            
            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
