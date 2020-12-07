/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerexamenparcial;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dani
 */
public class ServidorOpcionesRmi extends UnicastRemoteObject implements IOpciones {

    public ServidorOpcionesRmi() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        ServidorOpcionesRmi servidorOp;

        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidorOp = new ServidorOpcionesRmi();

            Naming.bind("ServidorOpciones", servidorOp); // Lo mas importante

            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int sumatoria(int n) {
        int sumat = 0;
        for (int i = 1; i <= n; i++) {
            sumat = sumat + i;
        }
        return sumat;
    }

    @Override
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    @Override
    public String invertirCadena(String cadena) {
        StringBuilder builder = new StringBuilder(cadena);
        String cadenaI = builder.reverse().toString();
        return cadenaI;
    }
}
