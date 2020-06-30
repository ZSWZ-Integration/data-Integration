package com.example.a_system.po.statistic;

import com.example.a_system.vo.StatisticCourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class StatisticCourseVOMapper implements RowMapper<StatisticCourseVO> {
    @Override
    public StatisticCourseVO mapRow(ResultSet resultSet, int i)throws SQLException {
        String cno=resultSet.getString("cno");
        String cname=resultSet.getString("cname");
        String teacher=resultSet.getString("teacher");
        String credit=resultSet.getString("credit");
        int count=Integer.parseInt(resultSet.getString("count"));
        return new StatisticCourseVO(cno,cname,teacher,credit,count);
    }
}
