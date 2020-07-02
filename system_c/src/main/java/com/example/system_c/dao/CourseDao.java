package com.example.system_c.dao;

import com.example.system_c.dao.Repository.CourseRepository;
import com.example.system_c.po.Course.*;

import com.example.system_c.vo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class CourseDao implements CourseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean addCourse(String No,String Name,String Teacher,String Credit,String isShare) {
        try {
            jdbcTemplate.update("insert into COURSE (No,Name,Teacher,Credit,isShare) values (?,?,?,?,?)", No,Name,Teacher,Credit,isShare);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCourse(String No) {
        try{
            jdbcTemplate.update("delete from COURSE where No=?",No);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCourse(String No,String Name,String Teacher,String Credit,String isShare) {
        try{
            jdbcTemplate.update("update COURSE set No=?,Name=?,Teacher=?,Credit=?,isShare=? where No=?",No,Name,Teacher,Credit,isShare,No);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean chooseCourse(String Sno,String Cno) {
        try{
            //String Sno=jdbcTemplate.queryForObject("select Sno from student where Sname=?",String.class,Sname);
            jdbcTemplate.update("insert into ELECTIVE(Cno,Sno,grade) values(?,?,?)",Cno,Sno,0);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean dropCourse(String Sno,String Cno) {
        try{
            //String Sno=jdbcTemplate.queryForObject("select Sno from student where Sname=?",String.class,Sname);
            jdbcTemplate.update("delete from `take_course` where Cno=? and Sno=?",Cno,Sno);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CoursePO> getStudentCourse(String Sno) {
        //String Sno=jdbcTemplate.queryForObject("select Sno from student where Sname=?",String.class,Sname);
        try {
            return jdbcTemplate.query("select * from course where course.No in (select Cno from elective where Sno=?)", new CourseMapper(), Sno);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CoursePO> getAllCourse() {
        return jdbcTemplate.query("select * from course",new CourseMapper());
    }

    @Override
    public List<Course> getSharedCourse(){  //外院系的共享课程本院的share字段为0
        return jdbcTemplate.query("select * from course where isShare=1",new CourseVOMapper());
    }

    @Override
    public int getCCoursesNum() {
        return jdbcTemplate.queryForObject("select count(*) from course where No like '%C%'",Integer.class);
    }

    @Override
    public Choice getChoiceInfo(String sno, String cno) {
        return jdbcTemplate.queryForObject("select * from elective where Sno=? and Cno=?",new ChoiceMapper(),sno,cno);
    }


}
