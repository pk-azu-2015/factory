
package com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dodajForme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dodajForme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idProjektu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dodajForme", propOrder = {
    "idProjektu"
})
public class DodajForme {

    protected int idProjektu;

    /**
     * Gets the value of the idProjektu property.
     * 
     */
    public int getIdProjektu() {
        return idProjektu;
    }

    /**
     * Sets the value of the idProjektu property.
     * 
     */
    public void setIdProjektu(int value) {
        this.idProjektu = value;
    }

}
