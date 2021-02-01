/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Dani
 */
public class serverUDP {

    public static void main(String args[]) {
        JuegoAhorcado JA = new JuegoAhorcado();
        int port = 6789;

        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion
                        = new DatagramPacket(bufer, bufer.length);

                // Leemos una petición del DatagramSocket
                socketUDP.receive(peticion);

                System.out.print("Datagrama recibido del host: "
                        + peticion.getAddress());
                System.out.println(" desde el puerto remoto: "
                        + peticion.getPort());

                //byte
                byte letra = peticion.getData()[0];
                char letra2 = (char)letra;
                String resp = JA.Jugar(letra2);
                byte[] mensaje =  resp.getBytes();
                System.out.println(resp+letra2);
                // byte a = (byte) JA.Jugar(peticion.getData());
                // declaramos un array de bytes  con los bit necesarios "a"
                //String mensaje = new String [resp];
                // mensaje[0] = a;

                // Construimos el DatagramPacket para enviar la respuesta
                DatagramPacket respuesta = new DatagramPacket(mensaje, 1,
                        peticion.getAddress(), peticion.getPort());

                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}
