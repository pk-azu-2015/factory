/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aznu.webservices;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import localhost._8080.magazyn.Magazyn;
import localhost._8080.magazyn.Magazyn_Service;
import localhost._8080.magazyn.Projekt;

/**
 *
 * @author root
 */
@WebService(serviceName = "QualityWebService")
public class QualityWebService {
  
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Magazyn/Magazyn.wsdl")
    private Magazyn_Service service;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sprawdzStan")
    public String sprawdzStan(@WebParam(name = "name") String nazwaNormy){          
        Norma norma = Norma.getEnum(nazwaNormy);
        try { // Call Web Service Operation
            localhost._8080.magazyn.Magazyn port = service.getMagazynPort();
            java.util.List<java.lang.Integer> productIdList = port.zwrocListeIDProduktow(Stan.POMALOWANY.getStanId());
            
            if(productIdList != null){
                for(Integer productId : productIdList ){
                    Projekt projekt = port.wezProdukt(productId, Stan.POMALOWANY.getStanId());
                    norma.sprawdzProdukt(projekt);
                }
            }
            return norma + " !" + String.join(",",productIdList.toString());
        } catch (Exception ex) {
            return "ERROR connecting with Magazyn Service";
        }
    }
}
