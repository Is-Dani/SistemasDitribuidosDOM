/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmilaboratorio;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dani
 */
public class ServidorRMIBancoCentral extends UnicastRemoteObject implements IBancoCentral {

    public ServidorRMIBancoCentral() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        ServidorRMIBancoCentral servidor;

        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorRMIBancoCentral();

            Naming.bind("BancoCentral", servidor); // Lo mas importante

            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double cotizaciondolar(String fecha) throws RemoteException {
        double dolar = 0;
        switch (fecha) {
            case "26-06-19":
                dolar = 6.90;
                break;

            case "27-06-19":
                dolar = 6.91;
                break;
            case "28-06-19":
                dolar = 6.93;
                break;

            case "29-06-19":
                dolar = 6.92;
                break;

            case "30-06-19":
                dolar = 6.96;
                break;

        }

        return dolar;
    }
}
