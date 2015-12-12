/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pk.azu.magazyn.database;

import java.sql.ResultSet;



/**
 *
 * @author strah
 */
public interface Connection {
    
    public void connect();
    public ResultSet execQuery(String query);
    public void update(String query);
    
}
