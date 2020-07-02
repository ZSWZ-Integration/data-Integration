package com.example.system_c.po.Course;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class ChoiceMapper implements RowMapper<Choice> {
    @Override
    public Choice mapRow(ResultSet resultSet, int i)throws SQLException {
        String sno=resultSet.getString("sno");
        String cno=resultSet.getString("cno");
        String grade=resultSet.getString("grade");
        return new Choice(cno,sno,grade);
    }
}
