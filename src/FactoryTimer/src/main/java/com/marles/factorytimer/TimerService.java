/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marles.factorytimer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.xml.ws.WebServiceRef;
import wsdl.classes.Factory;
import wsdl.classes.Factory_Service;
import wsdl.classes.Magazyn;
import wsdl.classes.Stan;
import wsdl.classes.IdProjektu;
import wsdl.classes.MagazynImpl;
/**
 *
 * @author Marzec
 */
@Singleton
public class TimerService {
    
     @WebServiceRef(wsdlLocation="http://localhost:8080/Factory-1.0-SNAPSHOT/Factory?wsdl")
    Factory_Service factoryService;
     
    @WebServiceRef(wsdlLocation="http://localhost:8080/Magazyn/Magazyn?wsdl")
    Magazyn magazynService;
  
    @Schedule(second="*/10", minute="*", hour="*", persistent=false)
    public void doWork(){
         Factory factoryPort = factoryService.getFactoryPort();
         MagazynImpl magazynPort = magazynService.getMagazynPort();
         Logger logger = Logger.getLogger(Factory.class.getName());
         int iloscZamowien = factoryPort.czytajIloscZamowien();
         if (iloscZamowien <= 0) {
             return;
         }
         int partsSize = 4;
         boolean[] parts = new boolean[partsSize];
         List<Integer> listaProduktow = magazynPort.zwrocListeIDProduktow(Stan.GOTOWY.ordinal());
         if (listaProduktow != null) {
             if (!listaProduktow.contains(IdProjektu.SILNIK.ordinal())) {
                 parts[0] = wykonajProjekt(factoryPort, IdProjektu.SILNIK);
             }
             if (!listaProduktow.contains(IdProjektu.KAROSERIA.ordinal())) {
                 parts[1] = wykonajProjekt(factoryPort, IdProjektu.KAROSERIA);
             }
             if (!listaProduktow.contains(IdProjektu.KOLO.ordinal())) {
                 parts[2] = wykonajProjekt(factoryPort, IdProjektu.KOLO);
             }
             if (!listaProduktow.contains(IdProjektu.PILOT.ordinal())) {
                 parts[3] = wykonajProjekt(factoryPort, IdProjektu.PILOT);
             }
            if (wszystkoTrue(parts)) {
               logger.log(Level.INFO, "Wykonano wszystkie częsći");
            } else {
               logger.log(Level.INFO, "Wykonano nie wszystkie częsći");
            }
            if (factoryPort.zlozSamochod()) {
               logger.log(Level.INFO, "Wykonano jeden samochodzik");
                factoryPort.zapiszIlosc(iloscZamowien - 1);
            } else {
               logger.log(Level.INFO, "Nie wykonano żadnego samochodzika");
            }
        }
    }

    private boolean wykonajProjekt(Factory factory, IdProjektu idProjektu) {
         int id = idProjektu.ordinal();
        if (factory.wykonajForme(id) == -1) {
            return false;
        }
        if (!factory.wykonajOdlew(id)) {
            return false;
        }
        if (!factory.szlifuj(id)) {
            return false;            
        }
        if (!factory.maluj(id)) {
            return false;            
        }
        return true;
    }

    private boolean wszystkoTrue(boolean[] parts) {
        for (boolean part : parts) {
            if (!part) {
                return false;
            }
        }
        return true;
    }
}