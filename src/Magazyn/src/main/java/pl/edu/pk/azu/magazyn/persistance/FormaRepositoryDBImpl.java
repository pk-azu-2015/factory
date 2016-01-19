package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.database.Connection;
import pl.edu.pk.azu.magazyn.database.MySqlConnectionFactory;
import pl.edu.pk.azu.magazyn.exceptions.ItemUsed;
import pl.edu.pk.azu.magazyn.exceptions.NoItemFound;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.edu.pk.azu.magazyn.model.*;

public class FormaRepositoryDBImpl implements FormaRepository{

    static final String tableName = "forma";
    Connection connection = null;
    ResultSet resultSet = null;
    
    public FormaRepositoryDBImpl() {
        connection = MySqlConnectionFactory.getConnection();
    }
    
    private boolean checkIfExistsAndFillResultSet (Forma forma) throws SQLException {
        resultSet = connection.execQuery("select * from "  + tableName +  " where idProjektu = \"" +
               forma.getTyp().name() + "\";");
         
        return resultSet.next();
    }
    
    private void updateCounter(int counter, Forma forma) throws SQLException {
        connection.update("update "  + tableName +  "  set counter =\" " + counter +
                            "\"where idProjektu = \"" + forma.getTyp().name() + "\";");
    }
    
    private void createNew(Forma forma) {
        connection.update("insert into "  + tableName +  " (idProjektu) values(\""
                        + forma.getTyp().name() + "\" );");
    }
    
    private int getCounter() throws SQLException{
        return resultSet.getInt("counter");
    }

    @Override
    public void dodajForme(Forma forma) {
        try {
            if (checkIfExistsAndFillResultSet(forma)) {
                int counter = getCounter();
                updateCounter(counter + 10, forma);
            }
            else {
                createNew(forma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void uzyjForme(Forma forma) throws NoItemFound, ItemUsed {
        
        try {
            if (checkIfExistsAndFillResultSet(forma)) {
                int counter = getCounter();
                if (counter > 0) {
                    updateCounter(counter - 1, forma);
                }
                else {
                    throw new ItemUsed(forma.toString());
                }  
            }
            else {
               throw new NoItemFound(forma.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int count(IdProjektu idProjektu) {
        try {
            if (checkIfExistsAndFillResultSet(idProjektu)) {
                return getCounter();   
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    private boolean checkIfExistsAndFillResultSet (IdProjektu idProjektu) throws SQLException {
        resultSet = connection.execQuery("select * from "  + tableName +  " where idProjektu = \"" +
               idProjektu.name() + "\";");
         
        return resultSet.next();
    }

}
