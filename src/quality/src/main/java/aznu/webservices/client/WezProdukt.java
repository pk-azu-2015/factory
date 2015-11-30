
package aznu.webservices.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wezProdukt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wezProdukt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idProjektu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wezProdukt", propOrder = {
    "idProjektu",
    "stan"
})
public class WezProdukt {

    protected int idProjektu;
    protected int stan;

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

    /**
     * Gets the value of the stan property.
     * 
     */
    public int getStan() {
        return stan;
    }

    /**
     * Sets the value of the stan property.
     * 
     */
    public void setStan(int value) {
        this.stan = value;
    }

}
