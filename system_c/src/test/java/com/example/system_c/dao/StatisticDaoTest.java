package com.example.system_c.dao;

import com.example.system_c.vo.StatisticCourse;
import com.example.system_c.vo.StatisticStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticDaoTest {
    @Autowired
    StatisticDao statisticDao;

    @Test
    public void test(){
        List<StatisticCourse> statisticCourses=statisticDao.getAllCourseStatistic();
        List<StatisticStudent> statisticStudents=statisticDao.getAllStudentStatistic();
    }



}
