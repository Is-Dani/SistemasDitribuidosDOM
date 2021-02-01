/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmilaboratorio;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dani
 */
public interface IServidorReserva  extends Remote {
   double cotizar(String incio, String fin, String fechacotizacion) throws RemoteException;
   String reservar(String inicio,String fin,String idcliente,String fechacompra) throws RemoteException;
}
