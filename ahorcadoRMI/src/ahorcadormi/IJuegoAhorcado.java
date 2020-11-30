/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dani
 */
public interface IJuegoAhorcado  extends Remote {
    String getGuiones() throws RemoteException;
    
    String jugar(char letra) throws RemoteException;
    
    
}
