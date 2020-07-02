package com.example.system_c.dao.Repository;

import com.example.system_c.vo.StatisticCourse;
import com.example.system_c.vo.StatisticStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository {
    public List<StatisticCourse> getAllCourseStatistic();
    public List<StatisticStudent> getAllStudentStatistic();
}
