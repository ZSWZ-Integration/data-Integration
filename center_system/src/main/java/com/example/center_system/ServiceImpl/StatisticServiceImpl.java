package com.example.center_system.ServiceImpl;

import com.example.center_system.Service.StatisticService;
import com.example.center_system.Service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    TransferService transferService;

    @Override
    public String getCourseListFromA() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8081/getAllCourseStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\courseA.xslt").substring(38);
    }

    @Override
    public String getCourseListFromB() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8082/educationalSystem_B/getAllCourseStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\courseB.xslt").substring(38);
    }

    @Override
    public String getCourseListFromC() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8083/getAllCourseStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\courseC.xslt").substring(38);
    }

    @Override
    public String getStudentListFromA() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8081/getAllStudentStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\studentA.xslt").substring(38);
    }

    @Override
    public String getStudentListFromB() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8082/educationalSystem_B/getAllStudentStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\studentB.xslt").substring(38);
    }

    @Override
    public String getStudentListFromC() throws IOException, TransformerException {
        String xml = transferService.getRequest("http://localhost:8083/getAllStudentStatistic");
        return transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\statistic\\studentC.xslt").substring(38);
    }
}
