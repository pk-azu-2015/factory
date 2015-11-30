
package aznu.webservices.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for idProjektu.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="idProjektu">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KOLO"/>
 *     &lt;enumeration value="SILNIK"/>
 *     &lt;enumeration value="KAROSERIA"/>
 *     &lt;enumeration value="PILOT"/>
 *     &lt;enumeration value="AUTO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "idProjektu")
@XmlEnum
public enum IdProjektu {

    KOLO,
    SILNIK,
    KAROSERIA,
    PILOT,
    AUTO;

    public String value() {
        return name();
    }

    public static IdProjektu fromValue(String v) {
        return valueOf(v);
    }

}
