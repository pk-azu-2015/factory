
package com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projekt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projekt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stan" type="{http://magazyn.azu.pk.edu.pl/}stan" minOccurs="0"/>
 *         &lt;element name="typ" type="{http://magazyn.azu.pk.edu.pl/}idProjektu" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projekt", propOrder = {
    "stan",
    "typ"
})
public class Projekt {

    @XmlSchemaType(name = "string")
    protected Stan stan;
    @XmlSchemaType(name = "string")
    protected IdProjektu typ;

    /**
     * Gets the value of the stan property.
     * 
     * @return
     *     possible object is
     *     {@link Stan }
     *     
     */
    public Stan getStan() {
        return stan;
    }

    /**
     * Sets the value of the stan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stan }
     *     
     */
    public void setStan(Stan value) {
        this.stan = value;
    }

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link IdProjektu }
     *     
     */
    public IdProjektu getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdProjektu }
     *     
     */
    public void setTyp(IdProjektu value) {
        this.typ = value;
    }

}
