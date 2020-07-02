package com.example.a_system.service;

import com.example.a_system.dao.Repository.StatisticRepository;

import com.example.a_system.vo.StatisticCourse;

import com.example.a_system.vo.StatisticCourseListVO;
import com.example.a_system.vo.StatisticStudent;
import com.example.a_system.vo.StatisticStudentListVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
