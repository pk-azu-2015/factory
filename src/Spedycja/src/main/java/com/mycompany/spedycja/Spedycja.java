/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spedycja;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jojo
 */
public class Spedycja {
    List<Item> kolejkaZamowien;
    private static Spedycja instance = null;
    protected Spedycja() {
        kolejkaZamowien=new LinkedList<Item>();
    }
    public static Spedycja getInstance() {
        if(instance == null) {
           instance = new Spedycja();
           
        }
        return instance;
    }
  
    
    
}
