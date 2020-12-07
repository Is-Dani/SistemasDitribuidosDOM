/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamenparcial;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Dani
 */
public class ServidorPrimoUdp {

    public static void main(String args[]) {
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

                //recibimos el numero  sacamos el factorial y lo convertimos a byte
                byte datos = peticion.getData()[0];
                int resp = primo(datos);
                byte a = (byte) primo(peticion.getData()[0]);
                // declaramos un array de bytes  con los bit necesarios "a"
                byte[] mensaje = new byte[a];
                mensaje[0] = a;

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

    public static int primo(int n) {
        int contador = 0;
        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                contador++;
            }
        }
        if (contador <= 2) {
            return 1;
        } else {
            return 2;
        }
    }
}
