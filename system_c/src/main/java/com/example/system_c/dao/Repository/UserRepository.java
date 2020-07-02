package com.example.system_c.dao.Repository;

import com.example.system_c.vo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public abstract Student login(String username, String password);
    public abstract boolean addStudent(String username, String password, String no, String name, String sex);
    public abstract boolean deleteStudent(String sno);
    public abstract Student getStudentInfo(String sno);
}
