/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marles.factorytimer;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.xml.ws.WebServiceRef;
import wsdl.classes.Factory_Service;
/**
 *
 * @author Marzec
 */
@Singleton
public class TimerService {
    
     @WebServiceRef(wsdlLocation="http://localhost:8080/Factory/Factory?wsdl")
    Factory_Service factoryService;
  
    @Schedule(second = "*/1", minute="*", hour="*", persistent=false)
    public void doWork(){
    }
}