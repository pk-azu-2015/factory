/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spedycja;

/**
 *
 * @author Jojo
 */
public class Item {
    private long kodProduktu;
    private int ilosc;
    private long idKlienta;

    /**
     * @return the kodProduktu
     */
    public long getKodProduktu() {
        return kodProduktu;
    }

    /**
     * @param kodProduktu the kodProduktu to set
     */
    public void setKodProduktu(long kodProduktu) {
        this.kodProduktu = kodProduktu;
    }

    /**
     * @return the ilosc
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * @param ilosc the ilosc to set
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * @return the idKlienta
     */
    public long getIdKlienta() {
        return idKlienta;
    }

    /**
     * @param idKlienta the idKlienta to set
     */
    public void setIdKlienta(long idKlienta) {
        this.idKlienta = idKlienta;
    }
}
