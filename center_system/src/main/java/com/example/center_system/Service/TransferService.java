package com.example.center_system.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface TransferService {

    String xmlTransfer(String xmlMessage, String xsltUri) throws TransformerException;

    Object xml2Object(String xml, Class<?> cls) throws JsonProcessingException;

    String postRequest(String xml, String uri) throws IOException;

    String getRequest(String uri) throws IOException;

}
