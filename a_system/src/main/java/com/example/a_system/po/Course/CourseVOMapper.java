package com.example.a_system.po.Course;

import com.example.a_system.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class CourseVOMapper implements RowMapper<CourseVO> {
    @Override
    public CourseVO mapRow(ResultSet resultSet, int i)throws SQLException {
        String Cno=resultSet.getString("Cno");
        String Cname=resultSet.getString("Cname");
        String teacher=resultSet.getString("teacher");
        String Ctime=resultSet.getString("Ctime");
        String credit=resultSet.getString("credit");
        String share=resultSet.getString("share");
        String Ctype=resultSet.getString("Ctype");
        return new CourseVO(Cno,Cname,teacher,Ctime,credit,share,Ctype);
    }
}