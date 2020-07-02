package com.example.a_system.dao;

import com.example.a_system.dao.Repository.CourseRepository;
import com.example.a_system.po.Course.*;

import com.example.a_system.vo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class CourseDao implements CourseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean addCourse(String Cno,String Cname,String ctime,String teacher,String credit,String type,String isShared) {
        try {
            jdbcTemplate.update("insert into `course` (Cno,Cname,teacher,Ctime,credit,Ctype,share) values (?,?,?,?,?,?,?)", Cno, Cname,  teacher,ctime, credit, type, isShared);
            return true;
        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println("不能重复添加课程");
            return false;
        }
    }

    @Override
    public boolean deleteCourse(String Cno) {
        try{
            jdbcTemplate.update("delete from `course` where Cno=?",Cno);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCourse(String Cno,String Cname,String ctime,String teacher,String credit,String type,String isShared) {
        try{
            jdbcTemplate.update("update `course` set Cname=?,ctime=?,teacher=?,credit=?,Ctype=?,share=? where Cno=?",Cname,ctime,teacher,credit,type,isShared,Cno);
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
            System.out.println("chooseCourse Sno is "+Sno+" and Cno is "+Cno);
            jdbcTemplate.update("insert into `take_course` (Cno,Sno,grade) values (?,?,?)",Cno,Sno,0);
            return true;
        }catch (Exception e) {
            //e.printStackTrace();
            System.out.println("不能重复选课");
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
    public List<com.example.a_system.po.Course.CoursePO> getStudentCourse(String Sno) {
        //String Sno=jdbcTemplate.queryForObject("select Sno from student where Sname=?",String.class,Sname);
        try {
            return jdbcTemplate.query("select * from course where course.Cno in (select Cno from take_course where Sno=?);", new CourseMapper(), Sno);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<com.example.a_system.po.Course.CoursePO> getAllCourse() {
        return jdbcTemplate.query("select * from course",new CourseMapper());
    }

    @Override
    public List<Course> getSharedCourse(){  //外院系的共享课程本院的share字段为0
        return jdbcTemplate.query("select * from course where share=1",new CourseVOMapper());
    }

    @Override
    public int getACoursesNum() {
        return jdbcTemplate.queryForObject("select count(*) from course where Ctype='A'",Integer.class);
    }

    @Override
    public Choice getChoiceInfo(String sno, String cno) {
        return jdbcTemplate.queryForObject("select * from take_course where Sno=? and Cno=?",new ChoiceMapper(),sno,cno);
    }


}
