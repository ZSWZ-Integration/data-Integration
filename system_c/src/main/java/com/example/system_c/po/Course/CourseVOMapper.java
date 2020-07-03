package com.example.system_c.po.Course;

import com.example.system_c.vo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class CourseVOMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet resultSet, int i)throws SQLException {
        String Cno=resultSet.getString("NO");
        String Cname=resultSet.getString("NAME");
        String teacher=resultSet.getString("TEACHER");
        String credit=resultSet.getString("credit");
        String share=resultSet.getString("isShare");
        return new Course(Cno,Cname,teacher,credit,share);
    }
}