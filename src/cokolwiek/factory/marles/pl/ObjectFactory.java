
package factory.marles.pl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the factory.marles.pl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WykonajOdlew_QNAME = new QName("http://factory.marles.pl/", "wykonajOdlew");
    private final static QName _WykonajOdlewResponse_QNAME = new QName("http://factory.marles.pl/", "wykonajOdlewResponse");
    private final static QName _Szlifuj_QNAME = new QName("http://factory.marles.pl/", "szlifuj");
    private final static QName _WykonajForme_QNAME = new QName("http://factory.marles.pl/", "wykonajForme");
    private final static QName _SzlifujResponse_QNAME = new QName("http://factory.marles.pl/", "szlifujResponse");
    private final static QName _WykonajFormeResponse_QNAME = new QName("http://factory.marles.pl/", "wykonajFormeResponse");
    private final static QName _MalujResponse_QNAME = new QName("http://factory.marles.pl/", "malujResponse");
    private final static QName _Maluj_QNAME = new QName("http://factory.marles.pl/", "maluj");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: factory.marles.pl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Maluj }
     * 
     */
    public Maluj createMaluj() {
        return new Maluj();
    }

    /**
     * Create an instance of {@link MalujResponse }
     * 
     */
    public MalujResponse createMalujResponse() {
        return new MalujResponse();
    }

    /**
     * Create an instance of {@link WykonajFormeResponse }
     * 
     */
    public WykonajFormeResponse createWykonajFormeResponse() {
        return new WykonajFormeResponse();
    }

    /**
     * Create an instance of {@link SzlifujResponse }
     * 
     */
    public SzlifujResponse createSzlifujResponse() {
        return new SzlifujResponse();
    }

    /**
     * Create an instance of {@link Szlifuj }
     * 
     */
    public Szlifuj createSzlifuj() {
        return new Szlifuj();
    }

    /**
     * Create an instance of {@link WykonajForme }
     * 
     */
    public WykonajForme createWykonajForme() {
        return new WykonajForme();
    }

    /**
     * Create an instance of {@link WykonajOdlew }
     * 
     */
    public WykonajOdlew createWykonajOdlew() {
        return new WykonajOdlew();
    }

    /**
     * Create an instance of {@link WykonajOdlewResponse }
     * 
     */
    public WykonajOdlewResponse createWykonajOdlewResponse() {
        return new WykonajOdlewResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WykonajOdlew }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "wykonajOdlew")
    public JAXBElement<WykonajOdlew> createWykonajOdlew(WykonajOdlew value) {
        return new JAXBElement<WykonajOdlew>(_WykonajOdlew_QNAME, WykonajOdlew.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WykonajOdlewResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "wykonajOdlewResponse")
    public JAXBElement<WykonajOdlewResponse> createWykonajOdlewResponse(WykonajOdlewResponse value) {
        return new JAXBElement<WykonajOdlewResponse>(_WykonajOdlewResponse_QNAME, WykonajOdlewResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Szlifuj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "szlifuj")
    public JAXBElement<Szlifuj> createSzlifuj(Szlifuj value) {
        return new JAXBElement<Szlifuj>(_Szlifuj_QNAME, Szlifuj.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WykonajForme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "wykonajForme")
    public JAXBElement<WykonajForme> createWykonajForme(WykonajForme value) {
        return new JAXBElement<WykonajForme>(_WykonajForme_QNAME, WykonajForme.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SzlifujResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "szlifujResponse")
    public JAXBElement<SzlifujResponse> createSzlifujResponse(SzlifujResponse value) {
        return new JAXBElement<SzlifujResponse>(_SzlifujResponse_QNAME, SzlifujResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WykonajFormeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "wykonajFormeResponse")
    public JAXBElement<WykonajFormeResponse> createWykonajFormeResponse(WykonajFormeResponse value) {
        return new JAXBElement<WykonajFormeResponse>(_WykonajFormeResponse_QNAME, WykonajFormeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MalujResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "malujResponse")
    public JAXBElement<MalujResponse> createMalujResponse(MalujResponse value) {
        return new JAXBElement<MalujResponse>(_MalujResponse_QNAME, MalujResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Maluj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://factory.marles.pl/", name = "maluj")
    public JAXBElement<Maluj> createMaluj(Maluj value) {
        return new JAXBElement<Maluj>(_Maluj_QNAME, Maluj.class, null, value);
    }

}
