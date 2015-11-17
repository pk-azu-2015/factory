/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.pk.azu.magazyn.model;

/**
 *
 * @author student
 */
public class Projekt {
    private IdProjektu typ;
    private Stan stan;
    
    public Projekt(IdProjektu typ, Stan stan) {
        this.typ = typ;
        this.stan = stan;
    }

    public IdProjektu getTyp() {
        return typ;
    }

    public void setTyp(IdProjektu typ) {
        this.typ = typ;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }
}

