/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spedycja;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author student
 */
@WebService(serviceName = "SpedycjaWebService")
public class SpedycjaWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "przygotujSklep")
    public String przygotujSklep(@WebParam(name = "name") String txt) {
        return "przygotujSklep " + txt + " !";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "przygotujNaprawe")
    public String przygotujNaprawe(@WebParam(name = "name") String txt) {
        return "przygotujNaprawe " + txt + " !";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "nadajPrzesylke")
    public String nadajPrzesylke(@WebParam(name = "name") String txt) {
        return "nadajPrzesylke " + txt + " !";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sledzPrzesylke")
    public String sledzPrzesylke(@WebParam(name = "name") String txt) {
        return "sledzPrzesylke " + txt + " !";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "dostarczonoPrzesylke")
    public String dostarczonoPrzesylke(@WebParam(name = "name") String txt) {
        return "dostarczonoPrzesylke " + txt + " !";
    }
}
