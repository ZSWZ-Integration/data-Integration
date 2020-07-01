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

    public String getAllCourseStatistic(){
        try {
            List<StatisticCourse> statisticCourseVOS = statisticRepository.getAllCourseStatistic();
            //封装成大的xml,向集成服务器发送统计的xml数据
            StatisticCourseListVO statisticCourseListVO=new StatisticCourseListVO(statisticCourseVOS);
            String xml = object2Xml(statisticCourseListVO);      //大xml
            return xml;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String getAllStudentStatistic(){
        try{
            List<StatisticStudent> statisticStudentVOS=statisticRepository.getAllStudentStatistic();
            //Todo:封装成大的xml,向集成服务器发送统计的xml数据
            StatisticStudentListVO statisticStudentListVO=new StatisticStudentListVO(statisticStudentVOS);
            String xml = object2Xml(statisticStudentListVO);      //大xml
            return xml;
        }catch (Exception e){
        e.printStackTrace();
        return "";
        }
    }

    public String object2Xml(Object object) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(object);
    }

    public Object xml2Object(String xml, Class<?> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        return objectMapper.readValue(xml, cls);
    }


}
