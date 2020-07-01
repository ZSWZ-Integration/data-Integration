package com.example.center_system.Service;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface TransferService {

    String xmlTransfer(String xmlMessage, String xsltUri) throws TransformerException;


}
