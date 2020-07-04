package com.example.system_c.service;

import com.example.system_c.dao.Repository.StatisticRepository;
import com.example.system_c.vo.StatisticCourse;
import com.example.system_c.vo.StatisticCourseListVO;
import com.example.system_c.vo.StatisticStudent;
import com.example.system_c.vo.StatisticStudentListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    StatisticRepository statisticRepository;
    @Autowired
    XmlService xmlService;

    public String getAllCourseStatistic(){
        try {
            System.out.println("getAllCourseStatistic");
            List<StatisticCourse> statisticCourseVOS = statisticRepository.getAllCourseStatistic();
            //封装成大的xml,向集成服务器发送统计的xml数据
            StatisticCourseListVO statisticCourseListVO=new StatisticCourseListVO(statisticCourseVOS);
            String xml = xmlService.object2Xml(statisticCourseListVO);      //大xml
            //System.out.println(xml);
            return xml;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String getAllStudentStatistic(){
        try{
            System.out.println("getAllStudentStatistic");
            List<StatisticStudent> statisticStudentVOS=statisticRepository.getAllStudentStatistic();
            //封装成大的xml,向集成服务器发送统计的xml数据
            StatisticStudentListVO statisticStudentListVO=new StatisticStudentListVO(statisticStudentVOS);
            String xml = xmlService.object2Xml(statisticStudentListVO);      //大xml
            //System.out.println(xml);
            return xml;
        }catch (Exception e){
        e.printStackTrace();
        return "";
        }
    }



}
