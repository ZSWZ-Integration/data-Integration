package com.example.a_system.dao;

import com.example.a_system.dao.Repository.UserRepository;
import com.example.a_system.po.User.StudentMapper;
import com.example.a_system.vo.StudentVO;
import com.example.a_system.vo.StudentVO;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public StudentVO login(String username, String password) {
        try {
            return jdbcTemplate.queryForObject("select * from student where acc=? and password=?", new StudentMapper(), username, password);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addStudent(String acc, String password, String createDate, String sno, String sname, String sex) {
        try{
            jdbcTemplate.update("INSERT INTO `student` VALUES (?,?,?,?,?,?)",acc,password,createDate,sno,sname,sex);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(String sno) {
        try{
            jdbcTemplate.update("delete from student where sno=?",sno);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentVO getStudentInfo(String sno) {
        return jdbcTemplate.queryForObject("select * from student where Sno=?",new StudentMapper(),sno);
    }
}
