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
//        String xml = "<A系统学生选课信息><课程编号A>cno</课程编号A><学生信息A>" +
//                "<学生账号A>acc</学生账号A><学生密码A>password</学生密码A><创建日期A>date</创建日期A>" +
//                "<学生编号A>sno</学生编号A><学生姓名A>sname</学生姓名A><学生性别A>no</学生性别A>" +
//                "</学生信息A><学生成绩A>grade</学生成绩A></A系统学生选课信息>";
        String xml1 = "<A院系共享课程信息><课程列表A>" +
                "<课程信息A><课程编号A>1</课程编号A><课程名A>1</课程名A>" +
                "<授课教师A>1</授课教师A><课程时间A>1</课程时间A><课程学分A>1</课程学分A>" +
                "<是否共享A>1</是否共享A><所属学院A>1</所属学院A></课程信息A>" +
                "<课程信息A><课程编号A>2</课程编号A><课程名A>2</课程名A>" +
                "<授课教师A>2</授课教师A><课程时间A>2</课程时间A><课程学分A>2</课程学分A>" +
                "<是否共享A>2</是否共享A><所属学院A>2</所属学院A></课程信息A>" +
                "</课程列表A></A院系共享课程信息>";
        String xml2 = "<Request><courses><item><id>1</id><name>1</name><credit>1</credit>" +
                "<teacher>1</teacher><campus>鼓楼</campus><share>0</share>" +
                "</item><item><id>2</id><name>2</name><credit>2</credit>" +
                "<teacher>2</teacher><campus>鼓楼</campus><share>0</share></item>" +
                "<item><id>1</id><name>1</name><credit>1</credit>" +
                "<teacher>1</teacher><campus>仙林</campus><share>0</share></item>" +
                "<item><id>2</id><name>2</name><credit>2</credit><teacher>2</teacher>" +
                "<campus>仙林</campus><share>0</share></item></courses></Request>";
        String xml3 = "<C院系共享课程信息><课程列表C>" +
                "<课程信息C><课程编号C>1</课程编号C><课程名C>1</课程名C>" +
                "<授课教师C>1</授课教师C><课程时间C>1</课程时间C><课程学分C>1</课程学分C>" +
                "<是否共享C>1</是否共享C><所属学院C>1</所属学院C></课程信息C>" +
                "<课程信息C><课程编号C>2</课程编号C><课程名C>2</课程名C>" +
                "<授课教师C>2</授课教师C><课程时间C>2</课程时间C><课程学分C>2</课程学分C>" +
                "<是否共享C>2</是否共享C><所属学院C>2</所属学院C></课程信息C>" +
                "</课程列表C></C院系共享课程信息>";
        String xsltUri1 = "src\\main\\resources\\xslt\\shareCourse\\BtoA.xslt";
        String xsltUri2 = "src\\main\\resources\\xslt\\shareCourse\\CtoA.xslt";
        System.out.println(xmlTransfer(xml2, xsltUri1).substring(38)+xmlTransfer(xml3, xsltUri2).substring(38));
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
