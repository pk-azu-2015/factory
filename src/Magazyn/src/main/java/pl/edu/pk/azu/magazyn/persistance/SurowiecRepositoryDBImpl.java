package pl.edu.pk.azu.magazyn.persistance;

import pl.edu.pk.azu.magazyn.database.Connection;
import pl.edu.pk.azu.magazyn.database.MySqlConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurowiecRepositoryDBImpl implements SurowiecRepository{

    static final String tableName = "surowiec";
    Connection connection = null;
    ResultSet resultSet = null;
    
    public SurowiecRepositoryDBImpl() {
        connection = MySqlConnectionFactory.getConnection();
    }

    private boolean checkIfExistsAndFillResultSet () throws SQLException {
        resultSet = connection.execQuery("select * from "  + tableName +  " ;");        
        return resultSet.next();
    }
    
    private void createSurowiec(int ilosc) {
        connection.update("insert into "  + tableName +  " (counter) values(\""
                        + ilosc + "\");");
    }
    
    private int getCounter() throws SQLException{
        return resultSet.getInt("counter");
    }
    
    private void updateCounter(int counter) throws SQLException {
        connection.update("update "  + tableName +  "  set counter = \"" + counter + "\";");
    }
    
    @Override
    public void dodajSurowiec(int ilosc) {
        try {
            if (checkIfExistsAndFillResultSet()) {
                int counter = getCounter();
                updateCounter(counter + ilosc);
            }
            else {
                createSurowiec(ilosc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pobierzSurowiec(int ilosc) {
        try {
            if (checkIfExistsAndFillResultSet()) {
                int counter = getCounter();
                if (counter > ilosc) {
                    updateCounter(counter - ilosc);
                }
                else {
                    updateCounter(0);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormaRepositoryDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
