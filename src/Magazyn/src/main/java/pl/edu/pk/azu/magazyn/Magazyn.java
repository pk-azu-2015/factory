package pl.edu.pk.azu.magazyn;

import pl.edu.pk.azu.magazyn.exceptions.BadParam;
import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.Projekt;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,
        use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface Magazyn {
    @WebMethod(operationName = "dodajForme")
    Forma dodajForme(@WebParam(name = "idProjektu") int idProjektu)
            throws BadParam;

    @WebMethod(operationName = "uzyjForme")
    Forma uzyjForme(@WebParam(name = "idProjektu") int idProjektu)
            throws NoItemFound, ItemUsed, BadParam;

    @WebMethod(operationName = "umiescProdukt")
    Projekt umiescProdukt(@WebParam(name = "idProjektu") int idProjektu,
                          @WebParam(name = "stan") int stan)
            throws BadParam;

    @WebMethod(operationName = "wezProdukt")
    Projekt wezProdukt(@WebParam(name = "idProjektu") int idProjektu,
                       @WebParam(name = "stan") int stan)
            throws NoItemFound, BadParam;

    @Oneway
    @WebMethod(operationName = "wezSurowiec")
    void wezSurowiec(@WebParam(name = "ilosc") int ilosc);

    @WebMethod(operationName = "dodajSurowiec")
    int dodajSurowiec(@WebParam(name = "ilosc") int ilosc);

    @WebMethod(operationName = "zwrocListeIDProduktow")
    List<Integer> zwrocListeIDProduktow(@WebParam(name = "stan") int stan);

    @WebMethod(operationName = "info")
    String info();

    @WebMethod(operationName = "getAllCount")
    String getAllCount();
}

