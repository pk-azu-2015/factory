/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pk.azu.recyclingwebapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author student
 */
@WebService(serviceName = "recykling")
public class recykling {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Magazyn/Magazyn.wsdl")
    private pl.edu.pk.azu.magazyn.Magazyn_Service service;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello2")
    public String hello2() {
        //definiowanie połączenia z magazynem
        pl.edu.pk.azu.magazyn.Magazyn port;
        try {
            while(true)
            {
                Thread.sleep(1000); 
                //łączenie z magazynem
                port = service.getMagazynPort();
                //ustawienia generotora pseudolosowego
                Random generator = new Random();
                //definicja parametrów do interfejsu Magazynu
                final int stan = 5;//enum zepsutego produktu
                List<Integer> resources = new ArrayList<>();
                // pobieranie listy produktów do recyklingu
                try {
                   resources = port.zwrocListeIDProduktow(stan);
                   System.out.println("Result = "+ resources);
               } catch (Exception ex) {
                   System.out.println("Brak produktów do recyklingu");
                   System.out.println(ex.getMessage());
               }

               for(int idProjektu : resources) {
                   //Pobieranie produktu o konkretnym ID
                   try {
                       pl.edu.pk.azu.magazyn.Projekt result = port.wezProdukt(idProjektu, stan);
                       System.out.println("Result = " + result);
                   } catch (Exception ex) {
                       System.out.println("Brak konkretnego produkt do recyklingu");
                       System.out.println(ex.getMessage());
                   }

                   try { 
                       port.dodajSurowiec(generator.nextInt(idProjektu));//dodawani losowej ilości surowa do magazynu
                   } catch (Exception ex) {
                       System.out.println("napotkano problem podczas wysyłania surowca do Magazynu: ");
                       System.out.println(ex.getMessage());
                   }
               }
            }
        } catch (Exception ex){
            System.out.println("napotkano problem podczas połączenia do Magazynu: ");
            System.out.println(ex.getMessage());
        }
        
        return "tlotlotl";
    }
}
