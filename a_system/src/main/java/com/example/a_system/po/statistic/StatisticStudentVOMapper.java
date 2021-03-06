package com.example.a_system.po.statistic;

import com.example.a_system.vo.StatisticStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class StatisticStudentVOMapper implements RowMapper<StatisticStudent> {
    @Override
    public StatisticStudent mapRow(ResultSet resultSet, int i)throws SQLException {
        String sno=resultSet.getString("sno");
        String sname=resultSet.getString("sname");
        String sex=resultSet.getString("sex");
        String cno=resultSet.getString("cno");
        String cname=resultSet.getString("cname");
        String grade=resultSet.getString("grade");

        return new StatisticStudent(sno,sname,sex,cno,cname,grade);
    }
}
