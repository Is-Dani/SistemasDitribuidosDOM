/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldistribuidos;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DANI
 */
public interface IPlataformaIntercambio extends Remote {
    boolean realizarTransaccion(int idCliente, int idVendedor, int monto, String moneda) throws RemoteException;
}
