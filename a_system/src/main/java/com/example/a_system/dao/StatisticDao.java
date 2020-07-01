package com.example.a_system.dao;

import com.example.a_system.dao.Repository.StatisticRepository;
import com.example.a_system.po.statistic.StatisticCourseVOMapper;
import com.example.a_system.po.statistic.StatisticStudentVOMapper;
import com.example.a_system.vo.StatisticCourse;
import com.example.a_system.vo.StatisticStudent;
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
            List<StatisticCourse> statisticCourses =jdbcTemplate.query("select c.cno,c.cname,c.teacher,c.credit,(CASE WHEN count IS NOT NULL THEN count ELSE 0 END)as count from course c left join (select cno,count(*) as count from take_course group by cno)t on c.cno=t.cno;",new StatisticCourseVOMapper());
            return statisticCourses;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StatisticStudent> getAllStudentStatistic() {
        try{
            List<StatisticStudent> statisticStudents =jdbcTemplate.query("select s.sno,s.sname,s.sex,(CASE WHEN p.cno IS NOT NULL THEN p.cno ELSE \"\" END)as cno,(CASE WHEN p.cname IS NOT NULL THEN p.cname ELSE \"\" END)as cname,(CASE WHEN p.grade IS NOT NULL THEN p.grade ELSE \"\" END)as grade from student s left join (select t.sno,c.cno,c.cname,t.grade from course c,take_course t where c.cno=t.cno)p on s.sno=p.sno;",new StatisticStudentVOMapper());
            return statisticStudents;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
