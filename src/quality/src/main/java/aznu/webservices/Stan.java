/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aznu.webservices;

/**
 *
 * @author marcin
 */
public enum Stan {
    ODLANY(0),
    OSZLIFOWANY(1),
    POMALOWANY(2),
    DO_KONTROLI(3),
    GOTOWY(4),
    ZEPSUTY(5),
    DO_RECYKLINGU(6);
    
    private Integer stanId;
    
    Stan(Integer stan){
      this.stanId = stan;
    }
    
    public static Stan fromMagazynStan(localhost._8080.magazyn.Stan stan){
        for(Stan value : values()){
            if(value.name().equals(stan.value())){
                return value;
            } 
        }
        return null;
    }
    
    public static Stan fromInt(Integer fromInt){
        for(Stan value : values()){
            if(value.stanId.equals(fromInt)){
                return value;
            } 
        }
        return null;
    }
    
    public Integer getStanId(){
       return this.stanId;
    }
}
