/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pk.azu.magazyn.database;

/**
 *
 * @author strah
 */
public class MySqlConnectionFactory {

    private static MySqlConnection mysqlConnection = null;
    
   // @Override
    public static Connection getConnection() {
        if (mysqlConnection == null) {
            return new MySqlConnection();
        }
        return mysqlConnection;
    }
    
}
