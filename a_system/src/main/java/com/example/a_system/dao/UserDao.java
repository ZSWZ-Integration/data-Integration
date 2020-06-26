package com.example.a_system.dao;

import com.example.a_system.dao.Repository.UserRepository;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String login(String username, String password) {
        try {
            String Sname = jdbcTemplate.queryForObject("select Sname from student where acc=? and password=?", String.class, username, password);
            return Sname;
        }catch (Exception e){
            return "fail";
        }
    }
}
