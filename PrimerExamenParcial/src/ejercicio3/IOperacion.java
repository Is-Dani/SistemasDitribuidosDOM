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
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IOperacion extends Remote {
    Libro crear(Libro libro) throws RemoteException;
    String eliminar(String id) throws RemoteException;
    Libro editar(String id) throws RemoteException;

}
