package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.database.Connection;
import pl.edu.pk.azu.magazyn.database.MySqlConnectionFactory;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pl.edu.pk.azu.magazyn.model.Projekt;
import pl.edu.pk.azu.magazyn.model.Stan;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.edu.pk.azu.magazyn.model.IdProjektu;

public class ProjektRepositoryDBImpl implements ProjektRepository {

    private static final String tableName = "projekt";
    private Connection connection = null;
    private ResultSet resultSet = null;
    
    public ProjektRepositoryDBImpl() {
        connection = MySqlConnectionFactory.getConnection();
    }
    
    private boolean checkIfExistsProjektAndFillResultSet (Projekt projekt) throws SQLException {
        resultSet = connection.execQuery("select * from "  + tableName +  " where typ = \"" +
               projekt.getTyp().name() + "\" and " +
               "stan = \"" + projekt.getStan().name() + "\";");
         
        return resultSet.next();
    }
    
    private int getCounter() throws SQLException{
        return resultSet.getInt("counter");
    }
    
    private void decrementCounter(int counter, Projekt projekt) {
        connection.update("update " + tableName + " set counter =\"" + (counter-1) +
                            "\" where typ = \"" + projekt.getTyp().name() + "\""
                + " and stan = \"" + projekt.getStan().name() + "\";");
    }
     private void incrementCounter(int counter, Projekt projekt) {
        connection.update("update " + tableName + "  set counter =\"" + (counter+1) +
                          "\" where typ = \"" + projekt.getTyp().name() + "\""
                         + " and stan = \"" + projekt.getStan().name() + "\";");
    }
    
    private void createNew(Projekt projekt) {
        connection.update("insert into " + tableName + " (typ, stan) values(\""
                        + projekt.getTyp().name() + "\",\"" 
                        + projekt.getStan().name() + "\");");
    }
    
    @Override
    public void wezProjekt(Projekt projekt) throws NoItemFound {
        try {
            if (checkIfExistsProjektAndFillResultSet(projekt)) {
                int counter = getCounter();
                if (counter > 0) {
                    decrementCounter(counter, projekt);
                }
                else {
                    throw new NoItemFound(projekt.toString());
                }
            }
            else {
                throw new NoItemFound(projekt.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjektRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dodajProjekt(Projekt projekt) {
        try {
            if (checkIfExistsProjektAndFillResultSet(projekt)) {
                int counter = getCounter();
                incrementCounter(counter, projekt);    
            }
            else {
                createNew(projekt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjektRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Integer> zwrocProjektyOStanie(Stan stan) {
        
        List<Integer> projekty = new ArrayList<>();
        
        resultSet = connection.execQuery("select * from " + tableName + "  where " +
            "stan = \"" + stan.name() + "\";");
        
        try {
            while (resultSet.next()) {
                String projekt = resultSet.getString("typ");
                projekty.add(IdProjektu.valueOf(projekt).ordinal());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjektRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projekty;
    }

    @Override
    public int count(Stan stan, IdProjektu idProjektu) {
       
        try {
            if(checkIfExistsProjektAndFillResultSet(stan, idProjektu)){
                return getCounter();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjektRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    private boolean checkIfExistsProjektAndFillResultSet (Stan stan, IdProjektu idProjektu) throws SQLException {
        resultSet = connection.execQuery("select * from "  + tableName +  " where typ = \"" +
               idProjektu.name() + "\" and " +
               "stan = \"" + stan.name() + "\";");
         
        return resultSet.next();
    }

    
}