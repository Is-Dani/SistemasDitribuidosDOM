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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class ClienteAhorcado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char letra;
        String result = "Seguir";
        int port = 5001;
        try {
            while (true) {

                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

                System.out.println("Introduzca una letra");
                letra = sc.next().charAt(0);

                toServer.println(letra);  // PAra mandarle al servidor

                result = fromServer.readLine(); // Leemos el Resultado
                String[] resultado = result.split(",");
                String ganasteoPerdiste = resultado[0];
                System.out.println("cadena devuelta es: " + ganasteoPerdiste);
                System.out.println(resultado[1]);
                if (ganasteoPerdiste.equals("Ganaste")|| ganasteoPerdiste.equals("Perdiste")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
