
package com.example.a_system.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "aWebService", targetNamespace = "http://service.a_system.example.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AWebService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "AWebService")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "AWebService", targetNamespace = "http://service.a_system.example.com/", className = "com.example.a_system.service.AWebService_Type")
    @ResponseWrapper(localName = "AWebServiceResponse", targetNamespace = "http://service.a_system.example.com/", className = "com.example.a_system.service.AWebServiceResponse")
    public String aWebService();

}