
package aznu.webservices.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stan">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ODLANY"/>
 *     &lt;enumeration value="OSZLIFOWANY"/>
 *     &lt;enumeration value="POMALOWANY"/>
 *     &lt;enumeration value="DO_KONTROLI"/>
 *     &lt;enumeration value="GOTOWY"/>
 *     &lt;enumeration value="ZEPSUTY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stan")
@XmlEnum
public enum Stan {

    ODLANY,
    OSZLIFOWANY,
    POMALOWANY,
    DO_KONTROLI,
    GOTOWY,
    ZEPSUTY;

    public String value() {
        return name();
    }

    public static Stan fromValue(String v) {
        return valueOf(v);
    }

}
