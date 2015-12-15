package pl.marles.factory;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import wsdl.classes.IdProjektu;
import wsdl.classes.ItemUsed_Exception;
import wsdl.classes.Magazyn;
import wsdl.classes.Magazyn_Service;
import wsdl.classes.NoItemFound_Exception;
import wsdl.classes.Stan;


@WebService(serviceName = "Factory",
        targetNamespace = "http://localhost:8080/Factory/",
        portName = "FactoryPort")
public class Factory {
    @WebServiceRef(wsdlLocation = "http://localhost:8080/Magazyn/Magazyn?wsdl")
    private Magazyn_Service service;
    
    private final String NAZWA_PLIKU = "zamowienia.txt";
    
    @WebMethod(operationName = "wykonajForme")
    public int wykonajForme(@WebParam(name = "ID_Projektu") int idProjektu) {
        
        try {
            Magazyn magazyn = service.getMagazynPort();
            magazyn.wezSurowiec(1);
            
            magazyn.dodajForme(idProjektu);
        } catch (Exception ex) {
            return -1;
        }
        return idProjektu;
    }

    @WebMethod(operationName = "wykonajOdlew")
    public boolean wykonajOdlew(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = service.getMagazynPort();
        try {
            magazyn.uzyjForme(idProjekt);
        } catch (ItemUsed_Exception ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NoItemFound_Exception ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        magazyn.umiescProdukt(idProjekt, EnumUtils.stanToInt(Stan.ODLANY));
        return true;
    }
    
    
    
    @WebMethod(operationName = "szlifuj")
    public boolean szlifuj(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        try {
            magazyn.wezProdukt(idProjekt, EnumUtils.stanToInt(Stan.ODLANY));
            magazyn.umiescProdukt(idProjekt, EnumUtils.stanToInt(Stan.OSZLIFOWANY));
        } catch (NoItemFound_Exception ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    @WebMethod(operationName = "maluj")
    public boolean maluj(@WebParam(name = "ID_Projektu") int idProjekt) {
        Magazyn magazyn = new Magazyn_Service().getMagazynPort();
        try {
            magazyn.wezProdukt(idProjekt, EnumUtils.stanToInt(Stan.OSZLIFOWANY));
            magazyn.umiescProdukt(idProjekt, EnumUtils.stanToInt(Stan.POMALOWANY));
        } catch (NoItemFound_Exception ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    @WebMethod(operationName = "zlozZamowienie")
    public boolean zlozZamowienie(@WebParam(name = "ilosc") int iloscZamowionych) throws IOException {
        int stanPoczatkowy = wczytajStanPoczatkowy();
        if (stanPoczatkowy == -1) {
            return false;
        }
        System.out.println("stanPoczatkowy: " + stanPoczatkowy);
        return zapiszIlosc(stanPoczatkowy + iloscZamowionych);
    }

    private int wczytajStanPoczatkowy() {
        File plikZamowien = new File(NAZWA_PLIKU);
        int stanPoczatkowy = 0;
        if (plikZamowien.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(NAZWA_PLIKU));
                String linia = br.readLine().trim();
                stanPoczatkowy = Integer.parseInt(linia);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            } catch (IOException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
                }
            }
        }
        return stanPoczatkowy;
    }

    @WebMethod(operationName = "zapiszIlosc")
    public boolean zapiszIlosc(int nowaIlosc) {
        try {
            PrintWriter zapis = null;
            zapis = new PrintWriter(NAZWA_PLIKU);
            zapis.println(nowaIlosc);
            zapis.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @WebMethod(operationName = "czytajIloscZamowien")
    public int czytajIloscZamowien() {
        return wczytajStanPoczatkowy();
    }
    
    public static class EnumUtils {
        public static IdProjektu intToIdProjektu(int idAsInt) {
            return IdProjektu.values()[idAsInt];
        }

        public static Stan intToStan(int stanAsInt) {
            return Stan.values()[stanAsInt];
        }

        public static int stanToInt(Stan stan) {
            return stan.ordinal();
        }
        
        public static int idProjektuToInt(IdProjektu typ) {
            return typ.ordinal();
        }
    }
}
