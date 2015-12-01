package pl.edu.pk.azu.magazyn;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;
import pl.edu.pk.azu.magazyn.persistance.*;
import pl.edu.pk.azu.magazyn.utils.EnumUtils;
import pl.edu.pk.azu.magazyn.utils.FormaFactory;
import pl.edu.pk.azu.magazyn.utils.ProjektFactory;

@WebService(serviceName = "Magazyn")
public class Magazyn {

    /***
     * The @Oneway annotation is placed on the methods in the SEI that will not require a response from the service.
     * The runtime does not wait for a response and will not reserve any resource to process a response.
     */

    FormaRepository formaRepository = FormaRepositoryFileImpl.getInstance();
    ProjektRepository projektRepository = ProjektRepositoryFileImpl.getInstance();
    SurowiecRepository surowiecRepository = SurowiecRepositoryFileImpl.getInstance();

    @WebMethod(operationName = "dodajForme")
    public void dodajForme(@WebParam(name = "idProjektu") int idProjektu) {
        Forma forma = FormaFactory.createForma(idProjektu);
        formaRepository.dodajForme(forma);
    }

    @WebMethod(operationName = "uzyjForme")
    public void uzyjForme(@WebParam(name = "idProjektu") int idProjektu) {

    }

    @WebMethod(operationName = "umiescProdukt")
    public void umieszProdukt(@WebParam(name = "idProjektu") int idProjektu,
                              @WebParam(name = "stan") int stan) {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.dodajProjekt(projekt);
    }

    @WebMethod(operationName = "wezProdukt")
    public Projekt wezProdukt(@WebParam(name = "idProjektu") int idProjektu,
                              @WebParam(name = "stan") int stan) throws NoItemFound {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.wezProjekt(projekt);
        return projekt;

    }


    @WebMethod(operationName = "wezSurowiec")
    public void wezSurowiec(@WebParam(name = "ilosc") int ilosc) {
        surowiecRepository.pobierzSurowiec(ilosc);
    }

    @WebMethod(operationName = "zamowSurowiec")
    public void zamowSurowiec() {
        //TODO: Połączenie ze spedycją
    }

    @WebMethod(operationName = "dodajSurowiec")
    public void dodajSurowiec(@WebParam(name = "ilosc") int ilosc) {
        surowiecRepository.dodajSurowiec(ilosc);
    }

    @WebMethod(operationName = "zwrocListeIDProduktow")
    public List<Integer> zwrocListeIDProduktow(@WebParam(name = "stan") int stan) {
        return null;
    }

}
