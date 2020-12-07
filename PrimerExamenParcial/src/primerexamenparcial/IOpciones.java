/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamenparcial;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dani
 */
public interface IOpciones extends Remote{
    public int sumatoria(int n) throws RemoteException;
    public int factorial(int n) throws RemoteException;
    public String invertirCadena(String cadena) throws RemoteException;
}
