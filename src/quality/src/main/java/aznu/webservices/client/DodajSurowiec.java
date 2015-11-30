
package aznu.webservices.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dodajSurowiec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dodajSurowiec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ilosc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dodajSurowiec", propOrder = {
    "ilosc"
})
public class DodajSurowiec {

    protected int ilosc;

    /**
     * Gets the value of the ilosc property.
     * 
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * Sets the value of the ilosc property.
     * 
     */
    public void setIlosc(int value) {
        this.ilosc = value;
    }

}
