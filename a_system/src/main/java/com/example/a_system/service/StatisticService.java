package com.example.a_system.service;

import com.example.a_system.dao.Repository.StatisticRepository;
import com.example.a_system.vo.StatisticCourseVO;
import com.example.a_system.vo.StatisticStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    public String getAllCourseStatistic(){
        try {
            List<StatisticCourseVO> statisticCourseVOS = statisticRepository.getAllCourseStatistic();
            //Todo:封装成大的xml,向集成服务器发送统计的xml数据
            String xml="";      //大xml

            return xml;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public String getAllStudentStatistic(){
        try{
            List<StatisticStudentVO> statisticStudentVOS=statisticRepository.getAllStudentStatistic();
            //Todo:封装成大的xml,向集成服务器发送统计的xml数据
            String xml="";      //大xml

            return xml;
        }catch (Exception e){
        e.printStackTrace();
        return "";
    }
    }


}
