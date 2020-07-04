
package com.example.system_c.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.system_c.service package. 
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

    private final static QName _CWebService_QNAME = new QName("http://service.system_c.example.com/", "CWebService");
    private final static QName _CWebServiceResponse_QNAME = new QName("http://service.system_c.example.com/", "CWebServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.system_c.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CWebService_Type }
     * 
     */
    public CWebService_Type createCWebService_Type() {
        return new CWebService_Type();
    }

    /**
     * Create an instance of {@link CWebServiceResponse }
     * 
     */
    public CWebServiceResponse createCWebServiceResponse() {
        return new CWebServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CWebService_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.system_c.example.com/", name = "CWebService")
    public JAXBElement<CWebService_Type> createCWebService(CWebService_Type value) {
        return new JAXBElement<CWebService_Type>(_CWebService_QNAME, CWebService_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CWebServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.system_c.example.com/", name = "CWebServiceResponse")
    public JAXBElement<CWebServiceResponse> createCWebServiceResponse(CWebServiceResponse value) {
        return new JAXBElement<CWebServiceResponse>(_CWebServiceResponse_QNAME, CWebServiceResponse.class, null, value);
    }

}
