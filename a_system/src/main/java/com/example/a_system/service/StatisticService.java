package com.example.a_system.service;

import com.example.a_system.dao.Repository.StatisticRepository;
import com.example.a_system.vo.StatisticCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    StatisticRepository statisticRepository;

    public boolean getAllCourseStatistic(){
        try {
            List<StatisticCourse> statisticCourses = statisticRepository.getAllCourseStatistic();
            //Todo:向集成服务器发送统计的xml数据


            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
