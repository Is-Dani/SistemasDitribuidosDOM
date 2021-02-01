/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmilaboratorio;

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
public class ClienteReserva {

    public static void main(String[] args) {
        IServidorReserva reserva;
        Scanner sc = new Scanner(System.in);
        int op;
        try {
            reserva = (IServidorReserva) Naming.lookup("rmi://localhost/ServidorReserva");
            
            

            do {
                System.out.println("1.- Cotizar");
                System.out.println("2.- Reservar");
                System.out.println("3.- Salir");
                System.out.println("Intruduzca la Opcion....");
                op = sc.nextInt();
                switch(op){
                    case 1:
                        double cotizacion = reserva.cotizar("06-12-2020", "25-12-2020", "26-06-19"); 
                        System.out.println(cotizacion);
                        break;
                    case 2:
                        String respuesta = reserva.reservar("06-12-2020", "25-12-2020", "3", "26-06-19");
                        System.out.println(respuesta);
                        break;
                    
                }

            }while(op!=3);
                
                
                
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteReserva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
