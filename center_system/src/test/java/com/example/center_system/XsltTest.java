package com.example.center_system;

import com.example.center_system.Service.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;

public class XsltTest {


    @Test
    public void Test() throws TransformerException {
        String xml = "<A系统学生选课信息><课程编号A>cno</课程编号A><学生信息A>" +
                "<学生账号A>acc</学生账号A><学生密码A>password</学生密码A><创建日期A>date</创建日期A>" +
                "<学生编号A>sno</学生编号A><学生姓名A>sname</学生姓名A><学生性别A>no</学生性别A>" +
                "</学生信息A><学生成绩A>grade</学生成绩A></A系统学生选课信息>";
        String xsltUri = "src\\main\\resources\\xslt\\test.xslt";
        System.out.println(xmlTransfer(xml, xsltUri));
    }

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
