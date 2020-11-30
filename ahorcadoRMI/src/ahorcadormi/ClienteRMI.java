/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

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
public class ClienteRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IJuegoAhorcado ahorcado;
        String guiones;
        String resultado = "Ganaste";
        Scanner sc = new Scanner(System.in);
        char letra;
        while (resultado == "Ganaste") {
            System.out.println("introduzca una letra");
            letra = sc.next().charAt(0);

            try {
                ahorcado = (IJuegoAhorcado) Naming.lookup("rmi://localhost/Ahorcado");
                resultado = ahorcado.jugar(letra);
                guiones = ahorcado.getGuiones();
                System.out.print(resultado);
                System.out.println("\n " + guiones);
                
            } catch (NotBoundException ex) {
                Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (resultado == "Ganaste" || resultado == "Perdiste") {
                    break;
                }

        }

    }
}
