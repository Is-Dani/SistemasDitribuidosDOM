/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamenparcial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class ClienteOpcionesRmi {

    public static void main(String[] args) {
        IOpciones opciones;
        Scanner sc = new Scanner(System.in);
        int op;
        int n = 0;
        String cadena;
        try {
            opciones = (IOpciones) Naming.lookup("rmi://localhost/ServidorOpciones");

            do {
                System.out.println("1.- Sumatoria");
                System.out.println("2.- Factorial");
                System.out.println("3.- Invertir Cadena");
                System.out.println("Intruduzca la Opcion....");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Introduzca un numero entero");
                        n = sc.nextInt();
                        int sumatoria = opciones.sumatoria(n);
                        System.out.println("la sumatoria de "+n+" es = "+sumatoria);
                        break;
                    case 2:
                        System.out.println("Introduzca un numero entero");
                        n = sc.nextInt();
                        int factorial = opciones.factorial(n);
                        System.out.println("el factorial de "+n+" es = "+factorial);
                        break;
                    case 3:
                        System.out.println("Introduzca una cadena");
                        cadena = sc.next();
                        String invertircadena = opciones.invertirCadena(cadena);
                        System.out.println("la cadena invertida de "+cadena+" es = "+invertircadena);
                        break;
                }

            } while (op != 3);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteOpcionesRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteOpcionesRmi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteOpcionesRmi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
