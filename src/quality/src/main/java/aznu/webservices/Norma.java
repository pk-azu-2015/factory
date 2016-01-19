/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aznu.webservices;

import static aznu.webservices.Stan.values;
import java.util.Random;
import localhost._8080.magazyn.Projekt;

/**
 *
 * @author root
 */
public enum Norma {
    EU_99,
    PL_80,
    EU_90;
    
   
    public static Norma getEnum(String value){
        for(Norma norma : values()){
            if(norma.name().equals(value)){
                return norma;
            } 
        }
        return null;
    }
    
    public Stan sprawdzProdukt(Projekt productId){
        Stan pokontroli = Stan.values()[new Random().nextInt(Stan.values().length)];
//        productId.setStan(EnumUtils)
                
        return pokontroli;
    }
    
}
