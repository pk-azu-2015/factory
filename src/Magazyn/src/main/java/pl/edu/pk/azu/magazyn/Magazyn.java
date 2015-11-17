package pl.edu.pk.azu.magazyn;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

/**
 *
 * @author student
 */
@WebService(serviceName = "Magazyn")
public class Magazyn {

    /**
     * This is a sample web service operation
     * @param idProjektu
     */
    @WebMethod(operationName = "dodajForme")
    public void dodajForme(@WebParam(name = "idProjektu") int idProjektu) {
                
    }
    
    @WebMethod(operationName = "uzyjForme")
    public void uzyjForme(@WebParam(name = "idProjektu") int idProjektu) {
        
    }
    
    @WebMethod(operationName = "umiescProdukt")
    public void umieszProdukt(@WebParam(name = "idProjektu") int idProjektu, 
            @WebParam(name = "stan") int stan) {
        
    }
    
    @WebMethod(operationName = "wezProdukt")
    public Projekt wezProdukt(@WebParam(name = "idProjektu") int idProjektu, 
         @WebParam(name = "stan") int stan) {
        IdProjektu idProjektu1 = IdProjektu.values()[idProjektu];
        Stan stan1 = Stan.values()[stan];
        return new Projekt(idProjektu1, stan1);
    }
    
    @WebMethod(operationName = "wezSurowiec")
    public void wezSurowiec(@WebParam(name = "ilosc") int ilosc) {
        
    }
    
    @WebMethod(operationName = "zamowSurowiec")
    public void zamowSurowiec() {
        
    }
    
    @WebMethod(operationName = "dodajSurowiec")
    public void dodajSurowiec(@WebParam(name = "ilosc") int ilosc) {
        
    }
    
    @WebMethod(operationName = "zwrocListeIDProduktow")
    public List<Integer> zwrocListeIDProduktow(@WebParam(name = "stan") int stan) {
        return null;
    }
    
}
