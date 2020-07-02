package com.example.center_system.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface StatisticService {

    String getCourseListFromA() throws IOException, TransformerException;

    String getCourseListFromB() throws IOException, TransformerException;

    String getCourseListFromC() throws IOException, TransformerException;

    String getStudentListFromA() throws IOException, TransformerException;

    String getStudentListFromB() throws IOException, TransformerException;

    String getStudentListFromC() throws IOException, TransformerException;

    //todo:与前端交互的业务逻辑

}
