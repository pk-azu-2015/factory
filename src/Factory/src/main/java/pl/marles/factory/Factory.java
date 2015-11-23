package pl.marles.factory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "Factory")
public class Factory {
    
    @WebMethod(operationName = "wykonajForme")
    public int wykonajForme(@WebParam(name = "ID_Projektu") int idProjektu) {
        
        return idProjektu;
    }

    @WebMethod(operationName = "wykonajOdlew")
    public boolean wykonajOdlew(@WebParam(name = "ID_Projektu") int idProjekt) {
        return true;
    }
    
    
    
    @WebMethod(operationName = "szlifuj")
    public boolean szlifuj(@WebParam(name = "ID_Projektu") int idProjekt) {
        return true;
    }
    
    @WebMethod(operationName = "maluj")
    public boolean maluj(@WebParam(name = "ID_Projektu") int idProjekt) {
        
        return true;
    }
}
