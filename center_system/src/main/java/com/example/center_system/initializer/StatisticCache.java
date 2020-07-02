package com.example.center_system.initializer;

import com.example.center_system.Service.StatisticService;
import com.example.center_system.Service.TransferService;
import com.example.center_system.vo.StatisticCourseListVO;
import com.example.center_system.vo.StatisticStudentListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Component
public class StatisticCache {

    @Autowired
    StatisticService statisticService;
    @Autowired
    TransferService transferService;

    public static StatisticCourseListVO courseCache = null;
    public static StatisticStudentListVO studentCache = null;

    @PostConstruct
    public void init() throws IOException, TransformerException {
        String courseXml = "<全部课程信息><课程列表>" +
                statisticService.getCourseListFromA() +
                statisticService.getCourseListFromB() +
                statisticService.getCourseListFromC() +
                "</课程列表></全部课程信息>";
        courseCache = (StatisticCourseListVO) transferService.xml2Object(courseXml, StatisticCourseListVO.class);
        String studentXml = "<学生选课信息><学生选课列表>" +
                statisticService.getStudentListFromA() +
                statisticService.getStudentListFromB() +
                statisticService.getStudentListFromC() +
                "</学生选课列表></学生选课信息>";
        studentCache = (StatisticStudentListVO) transferService.xml2Object(studentXml, StatisticStudentListVO.class);


        System.out.println("courseCache size is "+courseCache.getStatisticCourseList().size());
        System.out.println("studentCache size is "+studentCache.getStudentList().size());
    }

}
