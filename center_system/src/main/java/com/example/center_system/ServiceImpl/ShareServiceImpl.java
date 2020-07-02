package com.example.center_system.ServiceImpl;

import com.example.center_system.Service.ShareService;
import com.example.center_system.Service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    TransferService transferService;

    @Override
    public String AGetSharedCourse() throws IOException, TransformerException {
        String xmlB = transferService.getRequest("http://localhost:8082/educationalSystem_B/getSharedCourses");
        System.out.println("--------------B------------------");
        System.out.println(xmlB);
        //String xmlC = transferService.getRequest("http://localhost:8083/getSharedCourses");
        String xmlC="";
        System.out.println("--------------C------------------");
        System.out.println(xmlC);
//        String result = transferService.xmlTransfer(xmlB, "src\\main\\resources\\xslt\\shareCourse\\BtoA.xslt").substring(38) +
//                transferService.xmlTransfer(xmlC, "src\\main\\resources\\xslt\\shareCourse\\CtoA.xslt");
        String result = transferService.xmlTransfer(xmlB, "src\\main\\resources\\xslt\\shareCourse\\BtoA.xslt").substring(38);
        return "<A院系共享课程信息><课程列表A>" + result + "</课程列表A></A院系共享课程信息>";
    }

    @Override
    public String BGetSharedCourse() throws IOException, TransformerException {
        String xmlA = transferService.getRequest("http://localhost:8081/getSharedCourses");
        System.out.println("--------------A------------------");
        System.out.println(xmlA);
        String xmlC = transferService.getRequest("http://localhost:8083/getSharedCourses");
        System.out.println("--------------C------------------");
        System.out.println(xmlC);
        String result = transferService.xmlTransfer(xmlA, "src\\main\\resources\\xslt\\shareCourse\\AtoB.xslt").substring(38) +
                transferService.xmlTransfer(xmlC, "src\\main\\resources\\xslt\\shareCourse\\CtoB.xslt");
        //String result = transferService.xmlTransfer(xmlA, "src\\main\\resources\\xslt\\shareCourse\\AtoB.xslt").substring(38);
        return "<Request><courses>" + result + "</courses></Request>";
    }

    @Override
    public String CGetSharedCourse() throws IOException, TransformerException {
        String xmlA = transferService.getRequest("http://localhost:8081/getSharedCourses");
        String xmlB = transferService.getRequest("B_uri");
        String result = transferService.xmlTransfer(xmlA, "src\\main\\resources\\xslt\\shareCourse\\AtoC.xslt").substring(38) +
                transferService.xmlTransfer(xmlB, "src\\main\\resources\\xslt\\shareCourse\\BtoC.xslt");
        return "<C院系共享课程信息><课程列表C>" + result + "</课程列表C></C院系共享课程信息>";
    }
}
