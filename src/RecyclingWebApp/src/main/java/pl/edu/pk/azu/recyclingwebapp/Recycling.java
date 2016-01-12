    package pl.edu.pk.azu.recyclingwebapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author student
 */
@WebService(serviceName = "Recycling")
@Stateless()
public class Recycling {
    @WebServiceRef(
            wsdlLocation = "WEB-INF/wsdl/localhost_8080/Magazyn/Magazyn.wsdl"
    )
    private pl.edu.pk.azu.magazyn.Magazyn_Service service;
    
    private pl.edu.pk.azu.magazyn.Magazyn port;
    private final int stan = 5;
    private final Random generator = new Random();
    List<Integer> resourcesList = new ArrayList<>();

    
    private void sysException(Exception ex, String desc){
        System.out.println(desc);
        System.out.println(ex.getMessage());
    }
    
    private List<Integer> getProductsListID(){
        try {    
            resourcesList = port.zwrocListeIDProduktow(stan);
            System.out.println("Result = "+ resourcesList);
        } catch (Exception ex) {
            sysException(ex, "Brak produktów do recyklingu");
        }
        return resourcesList;
    }
    
    private void recycleSingleProduct(Integer idProjektu){
         pl.edu.pk.azu.magazyn.Projekt result = null;
        try {
            result = port.wezProdukt(idProjektu, stan);
            System.out.println("Result = " + result);
            //zwracanie na stan magazynu surowców
            returnResources(idProjektu);
        } catch (Exception ex) {
            sysException(ex, "Brak konkretnego produkt do recyklingu");
        }
    }
    
    private void returnResources(Integer idProjektu){
        try { 
            //dodawani losowej ilości surowa do magazynu
            port.dodajSurowiec(generator.nextInt(idProjektu));
        } catch (Exception ex) {
            sysException(ex, "napotkano problem podczas wysyłania surowca do " +
                    "Magazynu: ");
        }
    }
    
    private void mainLoop(){
        try {
            // pobieranie listy produktów do recyklingu
            resourcesList = getProductsListID();
            
           for(int idProjektu : resourcesList) {
               //Pobieranie produktu o konkretnym ID
             recycleSingleProduct(idProjektu); 
           }
        } catch (Exception ex){
            sysException(ex, "napotkano problem podczas połączenia do " +
                    "Magazynu: ");
        }
    }
    
    @WebMethod(operationName = "handleWithRecycling")
    public void handleWithRecycling() throws InterruptedException {
        port = service.getMagazynPort();
        while(true){
           mainLoop();
           Thread.sleep(100);
        }
    }
}
