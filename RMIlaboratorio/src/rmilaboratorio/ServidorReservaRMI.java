/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmilaboratorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class ServidorReservaRMI extends UnicastRemoteObject implements IServidorReserva {

    public ServidorReservaRMI() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        ServidorReservaRMI servidor;

        try {
            LocateRegistry.createRegistry(1100); // registrar el servidor e rmi register
            servidor = new ServidorReservaRMI();

            Naming.bind("ServidorReserva", servidor); // Lo mas importante

            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double cotizar(String incio, String fin, String fechacotizacion) throws RemoteException {
        double valor=0;
        switch (fechacotizacion) {
            case "26-06-19":
                valor = 30;
                break;
            case "27-06-19":
                valor = 25;
                break;
            case "28-06-19":
                valor = 25;
                break;
            case "29-06-19":
                valor = 35;
                break;
            case "30-06-19":
                valor = 40;
                break;

        }
       return valor * conectarBancoCentral(fechacotizacion);      
    }

    @Override
    public String reservar(String inicio, String fin, String idcliente, String fechacompra) throws RemoteException {
        
       double totalBolivianos = cotizar(inicio, fin, fechacompra);    // te da el total en dolares 30
      
       double valorFecha =  conectarBancoCentral(fechacompra);  // devuelve el valor del dolar en una deternimada fecha 6,90
 
       
       String cadena = idcliente + "," +String.valueOf(totalBolivianos);  //3,210
       
       String esExitosa = conectarBancoCliente(cadena); //1
       
       if(esExitosa.equals("1")){
           return "Compra Exitosa";
       }else{
           return "Compra Fallida";
       }
               
    }
    
    
    // este Cliente RMI que se conecta al servidor RMI banco Central
    public double conectarBancoCentral(String fecha){
        IBancoCentral bancoCentral;
        double dolar = 0.0;
        try {
            bancoCentral=(IBancoCentral)Naming.lookup("rmi://localhost/BancoCentral");
            dolar=bancoCentral.cotizaciondolar(fecha);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return dolar;
    }
    
    // Estes es el CLiente Soquet TCP que se conecta al servidor SOquetTCP BancoCLiente
    public String conectarBancoCliente(String cadena){
        String resultado = "";
        int port = 5001;
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println(cadena);  // Peticion
            
            resultado = fromServer.readLine();  // Respuesta del servidor

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
}
