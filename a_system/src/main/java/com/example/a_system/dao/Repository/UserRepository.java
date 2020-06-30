package com.example.a_system.dao.Repository;

import com.example.a_system.vo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public abstract Student login(String username, String password);
    public abstract boolean addStudent(String acc,String password,String createDate,String sno,String sname,String sex);
    public abstract boolean deleteStudent(String sno);

    public abstract Student getStudentInfo(String sno);
}
