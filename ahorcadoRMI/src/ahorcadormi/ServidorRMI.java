/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dani
 */
public class ServidorRMI  extends UnicastRemoteObject implements IJuegoAhorcado {

    JuegoAhorcado JA= new JuegoAhorcado();

    public ServidorRMI() throws RemoteException {
        super(); 
    }

    @Override
    public String getGuiones() throws RemoteException {
        return JA.getGuiones();
    }

    @Override
    public String jugar(char letra) throws RemoteException {
        return JA.Jugar(letra);
    }

    public static void main(String[] args) {
        ServidorRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorRMI();

            Naming.bind("Ahorcado", servidor); // Lo mas importante

            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
