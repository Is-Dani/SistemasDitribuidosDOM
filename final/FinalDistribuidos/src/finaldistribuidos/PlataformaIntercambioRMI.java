/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldistribuidos;

import Cliente2.Banco2;
import Cliente2.Banco2_Service;
import cliente1.Banco1;
import cliente1.Banco1_Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


/**
 *
 * @author DANI
 */
public class PlataformaIntercambioRMI extends UnicastRemoteObject implements IPlataformaIntercambio {

    private Banco1_Service servicio = new Banco1_Service();
    private Banco2_Service servicio2 = new Banco2_Service();
    private Banco1 banco1;
     private Banco2 banco2;

    Scanner sc = new Scanner(System.in);

    public PlataformaIntercambioRMI() throws RemoteException {
        super();
        banco1 = servicio.getBanco1Port();
        banco2 = servicio2.getBanco2Port();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PlataformaIntercambioRMI servidor;

        try {
            LocateRegistry.createRegistry(1199); // registrar el servidor e rmi register
            servidor = new PlataformaIntercambioRMI();

            Naming.bind("pi", servidor); // Lo mas importante

            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean realizarTransaccion(int idCliente, int idVendedor, int monto, String moneda) throws RemoteException {
        int opcion = 0;
        int montoBolivianos = 0;

        if (moneda == "DOLAR") {
            montoBolivianos = cotizacionDolar(monto);
        } else {
            montoBolivianos = monto;
        }

        do {
            System.out.println("1.- Retirar  2.- Abonar 3.- Salir");
            opcion = sc.nextInt();
        } while (opcion != 3);

        switch (opcion) {
            case 1:
                if (idCliente == 1) {
                    return banco1.retirar(idCliente, montoBolivianos);
                }
                if (idCliente == 3) {
                    return banco1.retirar(idCliente, montoBolivianos);
                }
                if (idCliente == 2) {
                    return banco2.retirar(idCliente, montoBolivianos);
                }
                if (idCliente == 4) {
                    return banco2.retirar(idCliente, montoBolivianos);
                }
            case 2:
                if (idCliente == 1) {
                    return banco1.abonar(idCliente, montoBolivianos);
                }
                if (idCliente == 3) {
                    return banco1.abonar(idCliente, montoBolivianos);
                }
                if (idCliente == 2) {
                    return banco2.abonar(idCliente, montoBolivianos);
                }
                if (idCliente == 4) {
                    return banco2.abonar(idCliente, montoBolivianos);
                }
            default:
                return false;
        }
    }

    public int cotizacionDolar(int monto) {
        int resultado = 0;
        int port = 5001;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("12-02-2021");
            String result = fromServer.readLine();
            resultado = Integer.parseInt(result);
            System.out.println("cadena devuelta es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

}
