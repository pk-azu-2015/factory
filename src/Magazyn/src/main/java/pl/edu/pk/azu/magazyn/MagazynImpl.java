package pl.edu.pk.azu.magazyn;

import java.util.List;

import pl.edu.pk.azu.magazyn.exceptions.BadParam;
import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;

import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import pl.edu.pk.azu.magazyn.model.Forma;
import pl.edu.pk.azu.magazyn.model.IdProjektu;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;
import pl.edu.pk.azu.magazyn.persistance.*;
import pl.edu.pk.azu.magazyn.utils.FormaFactory;
import pl.edu.pk.azu.magazyn.utils.ProjektFactory;

import javax.jws.WebService;
//import wsdl.classes.SpedycjaWebService;
//import wsdl.classes.SpedycjaWebService_Service;

@WebService(serviceName = "Magazyn",
        targetNamespace = "http://localhost:8080/Magazyn/",
        portName = "MagazynPort"
)
public class MagazynImpl implements Magazyn {
//
//    @WebServiceRef(wsdlLocation = "http://localhost:8080/Spedycja/SpedycjaWebService?wsdl")
//    private SpedycjaWebService_Service spedycjaWebService;

    private FormaRepository formaRepository = RepositoryFactory.newInstanceFormRepository();
    private SurowiecRepository surowiecRepository = RepositoryFactory.newInstanceSurowiecRepository();
    private ProjektRepository projektRepository = RepositoryFactory.newInstanceProjektRepository();




    @Override
    public Forma dodajForme(int idProjektu) throws BadParam {
        Forma forma = FormaFactory.createForma(idProjektu);
        formaRepository.dodajForme(forma);
        return forma;
    }

    @Override
    public Forma uzyjForme(int idProjektu) throws NoItemFound, ItemUsed, BadParam {
        Forma forma = FormaFactory.createForma(idProjektu);
        formaRepository.uzyjForme(forma);
        return forma;

    }

    @Override
    public Projekt umiescProdukt(int idProjektu,
                                 int stan) throws BadParam {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.dodajProjekt(projekt);
        return projekt;
    }

    @Override
    public Projekt wezProdukt(int idProjektu,
                              int stan) throws NoItemFound, BadParam {
        Projekt projekt = ProjektFactory.createProject(idProjektu, stan);
        projektRepository.wezProjekt(projekt);
        return projekt;

    }

    @Override
    public void wezSurowiec(int ilosc) {
        surowiecRepository.pobierzSurowiec(ilosc);
        int aktualnyStan = surowiecRepository.aktualnyStan();
        if(aktualnyStan < surowiecRepository.CRITICAL_LEVEL) {
            zamowSurowiec();
        }
    }


    private void zamowSurowiec() {
//        try {
//            SpedycjaWebService webServicePort = spedycjaWebService.getSpedycjaWebServicePort();
//            webServicePort.zamowSurowiec(100);
//        } catch (Exception ex){
//            System.err.println(ex.getMessage());
//        }
    }

    @Override
    public int dodajSurowiec(int ilosc) {
        surowiecRepository.dodajSurowiec(ilosc);
        return ilosc;
    }

    @Override
    public List<Integer> zwrocListeIDProduktow(int stan) {
        Stan stanEnum = Stan.fromInt(stan);
        List<Integer> idList = projektRepository.zwrocProjektyOStanie(stanEnum);
        return idList;
    }

    @Override
    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("\tMożliwe Stany:\n");
        for (Stan stan : Stan.values()) {
            builder.append(stan.toString()).append("\n");
        }
        builder.append("\tMożliwe IdProjektu:\n");
        for (IdProjektu idProjektu : IdProjektu.values()) {
            builder.append(idProjektu.toString()).append("\n");
        }

        return builder.toString();
    }

    @Override
    public String getAllCount() {
        return "";
    }

}
