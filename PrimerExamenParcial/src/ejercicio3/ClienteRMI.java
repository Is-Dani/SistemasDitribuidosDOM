/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

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

    public static void main(String[] args) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        IOperacion opciones;

        String id = "", titulo = "", autor = "", editorial = "";
        int anio = 0;
        
        Libro resp;
        String respuesta;
        try {
            opciones= (IOperacion) Naming.lookup("rmi://localhost/Servidor");  // Conectamos con el servidor

            do {
                System.out.println("1.- Crear");
                System.out.println("2.- Eliminar");
                System.out.println("3.- Editar");
                System.out.println("4.- Salir...");

                op = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("intro id: ");
                        id = sc.next();
                        System.out.print("intro titulo: ");
                        titulo = sc.next();
                        System.out.print("intro autor: ");
                        autor = sc.next();
                        System.out.print("intro editorial: ");
                        editorial = sc.next();
                        System.out.print("intro Anio: ");
                        anio = sc.nextInt();

                        Libro libro = new Libro(id, titulo, autor, editorial, anio);

                        resp = opciones.crear(libro);
                        System.out.println("id :" + resp.getId() + " nombre: " + resp.getTitulo() + " autor:" + resp.getAutor() + " editorial: " + resp.getEditorial() + " año: " + resp.getAnio());

                        break;
                    case 2:
                        System.out.print("intro id: ");
                        id = sc.next();
                        respuesta = opciones.eliminar(id);
                        System.out.println(respuesta);
                        break;

                    case 3:
                        System.out.print("intro id: ");
                        id = sc.next();
                        resp = opciones.editar(id);
                        System.out.println("id :" + resp.getId() + " nombre: " + resp.getTitulo() + " autor:" + resp.getAutor() + " editorial: " + resp.getEditorial() + " año: " + resp.getAnio());

                        break;
                }

            } while (op != 4);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
