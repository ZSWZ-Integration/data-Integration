package com.example.a_system.dao.Repository;

import com.example.a_system.vo.StatisticCourseVO;
import com.example.a_system.vo.StatisticStudentVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository {
    public List<StatisticCourseVO> getAllCourseStatistic();
    public List<StatisticStudentVO> getAllStudentStatistic();
}
