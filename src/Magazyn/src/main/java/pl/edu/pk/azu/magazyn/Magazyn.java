package pl.edu.pk.azu.magazyn;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;
import pl.edu.pk.azu.magazyn.persistance.*;
import pl.edu.pk.azu.magazyn.utils.EnumUtils;
import pl.edu.pk.azu.magazyn.utils.FormaFactory;
import pl.edu.pk.azu.magazyn.utils.ProjektFactory;

@WebService(serviceName = "Magazyn",
        targetNamespace = "http://localhost:8080/Magazyn/",
        portName = "MagazynPort"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Magazyn {

    FormaRepository formaRepository = RepositoryFactory.newInstanceFormRepository();
    ProjektRepository projektRepository = RepositoryFactory.newInstanceProjektRepository();
    SurowiecRepository surowiecRepository = RepositoryFactory.newInstanceSurowiecRepository();

    @WebMethod(operationName = "dodajForme")
    public Forma dodajForme(@WebParam(name = "idProjektu") int idProjektu) {
        Forma forma = FormaFactory.createForma(idProjektu);
        formaRepository.dodajForme(forma);
        return forma;
    }

    @WebMethod(operationName = "uzyjForme")
    public Forma uzyjForme(@WebParam(name = "idProjektu") int idProjektu) throws NoItemFound, ItemUsed {
        Forma forma = FormaFactory.createForma(idProjektu);
        formaRepository.uzyjForme(forma);
        return forma;

    }

    @WebMethod(operationName = "umiescProdukt")
    public Projekt umiescProdukt(@WebParam(name = "idProjektu") int idProjektu,
                              @WebParam(name = "stan") int stan) {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.dodajProjekt(projekt);
        return projekt;
    }

    @WebMethod(operationName = "wezProdukt")
    public Projekt wezProdukt(@WebParam(name = "idProjektu") int idProjektu,
                              @WebParam(name = "stan") int stan) throws NoItemFound {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.wezProjekt(projekt);
        return projekt;

    }

    @Oneway
    @WebMethod(operationName = "wezSurowiec")
    public void wezSurowiec(@WebParam(name = "ilosc") int ilosc) {
        surowiecRepository.pobierzSurowiec(ilosc);
        int aktualnyStan = surowiecRepository.aktualnyStan();
        if(aktualnyStan < surowiecRepository.CRITICAL_LEVEL) {
            zamowSurowiec();
        }
    }


    private void zamowSurowiec() {
        //TODO: Połączenie ze spedycją
    }

    @WebMethod(operationName = "dodajSurowiec")
    public int dodajSurowiec(@WebParam(name = "ilosc") int ilosc) {
        surowiecRepository.dodajSurowiec(ilosc);
        return ilosc;
    }

    @WebMethod(operationName = "zwrocListeIDProduktow")
    public List<Integer> zwrocListeIDProduktow(@WebParam(name = "stan") int stan) {
        Stan stanEnum = EnumUtils.intToStan(stan);
        List<Integer> idList = projektRepository.zwrocProjektyOStanie(stanEnum);
        return idList;
    }

}
