package com.example.system_c.dao;

import com.example.system_c.dao.Repository.UserRepository;
import com.example.system_c.po.User.StudentMapper;
import com.example.system_c.vo.Student;
import com.example.system_c.vo.Student;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Student login(String username, String password) {
        try {
            return jdbcTemplate.queryForObject("select * from student where username=? and passwd=?", new StudentMapper(), username, password);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addStudent(String username, String password, String no, String name, String sex) {
        try{
            jdbcTemplate.update("insert into student(username,passwd,no,name,sex) values(?,?,?,?,?)",username,password,no,name,sex);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(String sno) {
        try{
            jdbcTemplate.update("delete from student where no=?",sno);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentVO getStudentInfo(String sno) {
        return jdbcTemplate.queryForObject("select * from student where no=?",new StudentMapper(),sno);
    }
}
