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
        String acc=resultSet.getString("username");
        String password=resultSet.getString("passwd");
        String sno=resultSet.getString("no");
        String sname=resultSet.getString("name");
        String sex=resultSet.getString("sex");
        return new Student(acc,password,sno,sname,sex);
    }

}
