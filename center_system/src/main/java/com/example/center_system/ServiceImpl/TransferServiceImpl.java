package com.example.center_system.ServiceImpl;

import com.example.center_system.Service.TransferService;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;

@Service
public class TransferServiceImpl implements TransferService {

    @Override
    public String xmlTransfer(String xmlMessage, String xsltUri) throws TransformerException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(bytes);
        StreamResult result = new StreamResult(printWriter);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xsltUri));
        transformer.transform(new StreamSource(new StringReader(xmlMessage)), result);

        return bytes.toString();

    }


}
