
package pwebservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pwebservices package. 
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

    private final static QName _ListarMedicos_QNAME = new QName("http://PWebServices/", "listarMedicos");
    private final static QName _ListarMedicosResponse_QNAME = new QName("http://PWebServices/", "listarMedicosResponse");
    private final static QName _ReadByParam_QNAME = new QName("http://PWebServices/", "readByParam");
    private final static QName _ReadByParamResponse_QNAME = new QName("http://PWebServices/", "readByParamResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pwebservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarMedicos }
     * 
     */
    public ListarMedicos createListarMedicos() {
        return new ListarMedicos();
    }

    /**
     * Create an instance of {@link ListarMedicosResponse }
     * 
     */
    public ListarMedicosResponse createListarMedicosResponse() {
        return new ListarMedicosResponse();
    }

    /**
     * Create an instance of {@link ReadByParam }
     * 
     */
    public ReadByParam createReadByParam() {
        return new ReadByParam();
    }

    /**
     * Create an instance of {@link ReadByParamResponse }
     * 
     */
    public ReadByParamResponse createReadByParamResponse() {
        return new ReadByParamResponse();
    }

    /**
     * Create an instance of {@link Medico }
     * 
     */
    public Medico createMedico() {
        return new Medico();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMedicos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PWebServices/", name = "listarMedicos")
    public JAXBElement<ListarMedicos> createListarMedicos(ListarMedicos value) {
        return new JAXBElement<ListarMedicos>(_ListarMedicos_QNAME, ListarMedicos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarMedicosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PWebServices/", name = "listarMedicosResponse")
    public JAXBElement<ListarMedicosResponse> createListarMedicosResponse(ListarMedicosResponse value) {
        return new JAXBElement<ListarMedicosResponse>(_ListarMedicosResponse_QNAME, ListarMedicosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadByParam }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PWebServices/", name = "readByParam")
    public JAXBElement<ReadByParam> createReadByParam(ReadByParam value) {
        return new JAXBElement<ReadByParam>(_ReadByParam_QNAME, ReadByParam.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadByParamResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PWebServices/", name = "readByParamResponse")
    public JAXBElement<ReadByParamResponse> createReadByParamResponse(ReadByParamResponse value) {
        return new JAXBElement<ReadByParamResponse>(_ReadByParamResponse_QNAME, ReadByParamResponse.class, null, value);
    }

}
