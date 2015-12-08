/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spedycja;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

import pl.edu.pk.azu.magazyn.Magazyn;
import pl.edu.pk.azu.magazyn.Magazyn_Service;
import pl.edu.pk.azu.magazyn.NoItemFound_Exception;



/**
 *
 * @author student
 */
@WebService(serviceName = "SpedycjaWebService")
public class SpedycjaWebService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_17952/Magazyn/Magazyn.wsdl")
    //private localhost._8080.magazyn.Magazyn_Service service;
     private pl.edu.pk.azu.magazyn.Magazyn_Service service;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "przygotujSklep")
    public String przygotujSklep(@WebParam(name = "kod_produktu") long kod_produktu,
            @WebParam(name = "ilosc") int ilosc) {
        return "przygotujSklep ";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "przygotujNaprawe")
    public String przygotujNaprawe(@WebParam(name = "kod_produktu") long kod_produktu,
            @WebParam(name = "ilosc") int ilosc) {
        return "przygotujNaprawe";
    }
        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "zamowSurowiec")
    public String zamowSurowiec(@WebParam(name = "ilosc") int ilosc) {
        
        try { // Call Web Service Operation
            localhost._8080.magazyn.Magazyn port = service.getMagazynPort();
            // TODO initialize WS operation arguments here
            ilosc = 0;
            // TODO process result here
            int result = port.dodajSurowiec(ilosc);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return "zamowSurowiec " + ilosc + " !";
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
