package com.example.system_c.po.User;


import com.example.system_c.vo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i)throws SQLException {
        String acc=resultSet.getString("acc");
        String password=resultSet.getString("password");
        String createDate=resultSet.getString("createDate");
        String sno=resultSet.getString("sno");
        String sname=resultSet.getString("sname");
        String sex=resultSet.getString("sex");
        return new Student(acc,password,createDate,sno,sname,sex);
    }

}
