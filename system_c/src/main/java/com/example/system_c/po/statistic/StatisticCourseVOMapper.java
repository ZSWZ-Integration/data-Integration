package com.example.system_c.po.statistic;

import com.example.system_c.vo.StatisticCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class StatisticCourseVOMapper implements RowMapper<StatisticCourse> {
    @Override
    public StatisticCourse mapRow(ResultSet resultSet, int i)throws SQLException {
        String cno=resultSet.getString("no");
        String cname=resultSet.getString("name");
        String teacher=resultSet.getString("teacher");
        String credit=resultSet.getString("credit");
        int count=Integer.parseInt(resultSet.getString("count"));
        return new StatisticCourse(cno,cname,teacher,credit,count);
    }
}
