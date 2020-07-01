package com.example.a_system.dao.Repository;

import com.example.a_system.vo.StatisticCourse;
import com.example.a_system.vo.StatisticStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository {
    public List<StatisticCourse> getAllCourseStatistic();
    public List<StatisticStudent> getAllStudentStatistic();
}
