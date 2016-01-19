
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
