/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DANI
 */
@WebService(serviceName = "Banco2")
public class Banco2 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "abonar")
    public boolean abonar(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "monto") int monto) {
        if (idCliente == 4) {
            if (monto <= 40) {
                return true;
            }
        }
        if (idCliente == 50) {
            if (monto <= 300) {
                return true;
            }
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "retirar")
    public boolean retirar(@WebParam(name = "idCliente") int idCliente, @WebParam(name = "monto") int monto) {
        int monto1 = 40;
        int monto2 = 50;
        
        if (idCliente == 4) {
            monto = monto1 + monto;
            return true;
        } 
        
        if (idCliente == 2) {
            monto = monto2 + monto;
            return true;
        } 
        return false;
    }
}
