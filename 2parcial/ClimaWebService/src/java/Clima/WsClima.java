/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clima;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DANI
 */
@WebService(serviceName = "WsClima")
public class WsClima {

    /**
     * This is a sample web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getClimaTemperatura")
    public String getClimaTemperatura(@WebParam(name = "fecha") String fecha) {
        switch (fecha) {
            case "04-02-21":
                return "21";
            case "05-02-21":
                return "22";
            case "06-02-21":
                return "25";
            case "07-02-21":
                return "26";
            case "08-02-21":
                return "28";
            case "09-02-21":
                return "19";
            case "10-02-21":
                return "22";
            case "11-02-21":
                return "12";
            case "12-02-21":
                return "18";
            default:
                return "No existe";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getClimaPorcentaje")
    public String getClimaPorcentaje(@WebParam(name = "fecha") String fecha) {
        switch (fecha) {
            case "04-02-21":
                return "36.74%";
            case "05-02-21":
                return "80%";
            case "06-02-21":
                return "1.26%";
            case "07-02-21":
                return "0.42%";
            case "08-02-21":
                return "46.85%";
            case "09-02-21":
                return "4.21%";
            case "10-02-21":
                return "8.79%";
            case "11-02-21":
                return "0.69%";
            case "12-02-21":
                return "0.65%";
            default:
                return "No existe";
        }

    }
}
