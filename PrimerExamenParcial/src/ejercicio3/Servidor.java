/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author Dani
 */
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends UnicastRemoteObject implements IOperacion {

    private List<Libro> libreria = new ArrayList();

    Servidor() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String args[]) {

        try {
            Servidor servidor;
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new Servidor();
            Naming.bind("Servidor", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Libro crear(Libro libro) throws RemoteException {
        libreria.add(libro);
        return libro;
    }

    @Override
    public String eliminar(String id) throws RemoteException {

        for (Libro l : libreria) {
            if (l.getId().equals(id)) {
                libreria.remove(l);
                return "si: Eliminado";
            }
        }
        return "no: No Eliminado";
    }

    @Override
    public Libro editar(String id) throws RemoteException {
        for (Libro l : libreria) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

}
