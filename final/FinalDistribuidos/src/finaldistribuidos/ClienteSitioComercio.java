/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldistribuidos;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DANI
 */
public class ClienteSitioComercio {

    public static void main(String[] args) {
        System.out.println("holaaaaa");
        IPlataformaIntercambio plataformaIntercambio;
        Scanner sc = new Scanner(System.in);
        int op;
        try {
            plataformaIntercambio = (IPlataformaIntercambio) Naming.lookup("rmi://localhost/pi");

            /*do {
                System.out.println("1.- Cotizar");
                System.out.println("2.- Reservar");
                System.out.println("3.- Salir");
                System.out.println("Intruduzca la Opcion....");
                op = sc.nextInt();
                switch(op){
                }

            }while(op!=3);
            if (plataformaIntercambio.realizarTransaccion(1, 1, 10, "DOLAR")) {
                System.out.println("se realizo con exito");
            } else {
                System.out.println("hubo un error");
            }*/
            
            
            

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteSitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteSitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteSitioComercio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
