
package factory.marles.pl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for szlifuj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="szlifuj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_Projektu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "szlifuj", propOrder = {
    "idProjektu"
})
public class Szlifuj {

    @XmlElement(name = "ID_Projektu")
    protected int idProjektu;

    /**
     * Gets the value of the idProjektu property.
     * 
     */
    public int getIDProjektu() {
        return idProjektu;
    }

    /**
     * Sets the value of the idProjektu property.
     * 
     */
    public void setIDProjektu(int value) {
        this.idProjektu = value;
    }

}
