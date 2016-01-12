/**
 * create table if not exists forma(
        idFormy int primary key not null auto_increment,
        idProjektu text not null,
        counter int default 10
    );
        
    create table if not exists projekt(
        idProjektu int primary key not null auto_increment,
        typ text not null,
        stan text not null,
        counter int default 1 
    );
     
    create table if not exists surowiec (
        counter int primary key not null
    );
 */
package pl.edu.pk.azu.magazyn.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author strah
 */
public class MySqlConnection implements Connection{

    java.sql.Connection connection; 
    Statement statement;
    
    String userName;
    String password; 
    String host;
    
    public MySqlConnection() {
        connection = null;
        statement = null;
        
        userName = "azu2015";
        password = "azu2015";
        host = "jdbc:mysql://db4free.net/azu2015";
        
        connect();
    }
    
    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(host, userName, password);
            statement = connection.createStatement();
        }
        catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ResultSet execQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet; 
    }

    @Override
    public void update(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
