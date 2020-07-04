
package com.example.a_system.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.a_system.service package. 
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

    private final static QName _AWebServiceResponse_QNAME = new QName("http://service.a_system.example.com/", "AWebServiceResponse");
    private final static QName _AWebService_QNAME = new QName("http://service.a_system.example.com/", "AWebService");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.a_system.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AWebService_Type }
     * 
     */
    public AWebService_Type createAWebService_Type() {
        return new AWebService_Type();
    }

    /**
     * Create an instance of {@link AWebServiceResponse }
     * 
     */
    public AWebServiceResponse createAWebServiceResponse() {
        return new AWebServiceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AWebServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.a_system.example.com/", name = "AWebServiceResponse")
    public JAXBElement<AWebServiceResponse> createAWebServiceResponse(AWebServiceResponse value) {
        return new JAXBElement<AWebServiceResponse>(_AWebServiceResponse_QNAME, AWebServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AWebService_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.a_system.example.com/", name = "AWebService")
    public JAXBElement<AWebService_Type> createAWebService(AWebService_Type value) {
        return new JAXBElement<AWebService_Type>(_AWebService_QNAME, AWebService_Type.class, null, value);
    }

}
