package com.example.center_system.ServiceImpl;

import com.example.center_system.Service.TransferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

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


    @Override
    public Object xml2Object(String xml, Class<?> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        return objectMapper.readValue(xml, cls);
    }

    @Override
    public String postRequest(String xml, String uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        StringEntity stringEntity = new StringEntity(xml, StandardCharsets.UTF_8);
        stringEntity.setContentType("application/xml");
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        String result = "";
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        response.close();
        return result;
    }

    @Override
    public String getRequest(String uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        return EntityUtils.toString(entity, "utf-8");
    }


}
