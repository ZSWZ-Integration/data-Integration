package com.example.a_system.po.Course;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet resultSet, int i)throws SQLException {
        String Cno=resultSet.getString("Cno");
        String Cname=resultSet.getString("Cname");
        String teacher=resultSet.getString("teacher");
        String Ctime=resultSet.getString("Ctime");
        String credit=resultSet.getString("credit");
        String share=resultSet.getString("share");
        String Ctype=resultSet.getString("Ctype");
        return new Course(Cno,Cname,teacher,Ctime,credit,share,Ctype);
    }
}
