package com.example.a_system.dao.Repository;

import com.example.a_system.vo.StudentVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public abstract StudentVO login(String username,String password);
    public abstract boolean addStudent(String acc,String password,String createDate,String sno,String sname,String sex);
    public abstract boolean deleteStudent(String sno);

    public abstract StudentVO getStudentInfo(String sno);
}
