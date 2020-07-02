package com.example.system_c.po.Course;

import com.example.system_c.po.Course.CoursePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class CourseMapper implements RowMapper<CoursePO> {
    @Override
    public CoursePO mapRow(ResultSet resultSet, int i)throws SQLException {
        String Cno=resultSet.getString("Cno");
        String Cname=resultSet.getString("Cname");
        String teacher=resultSet.getString("teacher");
        String Ctime=resultSet.getString("Ctime");
        String credit=resultSet.getString("credit");
        String share=resultSet.getString("share");
        String Ctype=resultSet.getString("Ctype");
        return new CoursePO(Cno,Cname,teacher,Ctime,credit,share,Ctype);
    }
}
