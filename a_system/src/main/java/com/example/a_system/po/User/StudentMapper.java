package com.example.a_system.po.User;


import com.example.a_system.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class StudentMapper implements RowMapper<StudentVO> {
    @Override
    public StudentVO mapRow(ResultSet resultSet, int i)throws SQLException {
        String acc=resultSet.getString("acc");
        String password=resultSet.getString("password");
        String createDate=resultSet.getString("createDate");
        String sno=resultSet.getString("sno");
        String sname=resultSet.getString("sname");
        String sex=resultSet.getString("sex");
        return new StudentVO(acc,password,createDate,sno,sname,sex);
    }

}
