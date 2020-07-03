package com.example.system_c.dao;

import com.example.system_c.dao.Repository.StatisticRepository;
import com.example.system_c.po.statistic.StatisticCourseVOMapper;
import com.example.system_c.po.statistic.StatisticStudentVOMapper;
import com.example.system_c.vo.StatisticCourse;
import com.example.system_c.vo.StatisticStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticDao implements StatisticRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<StatisticCourse> getAllCourseStatistic() {
        try{
            List<StatisticCourse> statisticCourseVOS=jdbcTemplate.query("select c.no,c.name,c.teacher,c.credit,(CASE WHEN count IS NOT NULL THEN count ELSE 0 END)as count from course c left join (select cno,count(*) as count from elective group by cno)e on c.no=e.cno",new StatisticCourseVOMapper());
            return statisticCourseVOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StatisticStudent> getAllStudentStatistic() {
        try{
            List<StatisticStudent> statisticStudentVOS=jdbcTemplate.query("select s.no,s.name,s.sex,(CASE WHEN p.no IS NOT NULL THEN p.no ELSE \'\' END)as cno,(CASE WHEN p.name IS NOT NULL THEN p.name ELSE \'\' END)as cname,(CASE WHEN p.grade IS NOT NULL THEN p.grade ELSE \'\' END)as grade from student s left join (select e.sno,c.no,c.name,e.grade from course c,elective e where c.no=e.cno)p on s.no=p.sno",new StatisticStudentVOMapper());
            return statisticStudentVOS;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
