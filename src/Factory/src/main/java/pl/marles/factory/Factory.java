package pl.marles.factory;

import com.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "Factory")
public class Factory {
    
    @WebMethod(operationName = "wykonajForme")
    public int wykonajForme(@WebParam(name = "ID_Projektu") int idProjektu) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        magazyn.wezSurowiec(1);
        magazyn.dodajForme(idProjektu);
        return idProjektu;
    }

    @WebMethod(operationName = "wykonajOdlew")
    public boolean wykonajOdlew(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        magazyn.uzyjForme(idProjekt);
        magazyn.umiescProdukt(idProjekt, 0);
        return true;
    }
    
    
    
    @WebMethod(operationName = "szlifuj")
    public boolean szlifuj(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        magazyn.wezProdukt(idProjekt, 0);
        magazyn.umiescProdukt(idProjekt, 1);
        return true;
    }
    
    @WebMethod(operationName = "maluj")
    public boolean maluj(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        magazyn.wezProdukt(idProjekt, 1);
        magazyn.umiescProdukt(idProjekt, 2);
        return true;
    }
}
