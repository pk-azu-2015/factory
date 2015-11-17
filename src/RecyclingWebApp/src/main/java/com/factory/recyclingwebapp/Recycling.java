/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factory.recyclingwebapp;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author student
 */
@WebService(serviceName = "Recycling")
@Stateless()
public class Recycling {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !\nHave a nice day!";
    }
    
    @WebMethod(operationName = "handleWithRecycling")
    public void handleWithRecycling() {
        List<Integer> resources = new ArrayList<>();
        Integer idCrapu = 5;//Zepsuty produkt
        
       // Magazyn.
        
    }
    
    @WebMethod(operationName = "getCrapObjectList")
    public List<Integer> getCrapObjectList(@WebParam(name = "idStanu") Integer idStanu) {
        List<Integer> resources = new ArrayList<>();
        return resources ;
    }
    
    @WebMethod(operationName = "makeRecycling")
    public String makeRecycling(@WebParam(name = "idProduktu") Integer idProduktu, @WebParam(name = "idStanu") Integer idStanu) {
        return "idStanu: " + idStanu + "\n"
                + " idProduktu: " + idProduktu;
    }
    
    @WebMethod(operationName = "addResource")
    public void addResource(@WebParam(name = "ilosc") Integer ilosc) {
        
    }
}
