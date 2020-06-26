package com.example.a_system.dao.Repository;

import com.example.a_system.po.Course.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {
    //管理员操作
    public abstract boolean addCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String isShared);
    public abstract boolean deleteCourse(String Cno);
    public abstract boolean updateCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String isShared);
    //学生操作
    public abstract boolean chooseCourse(String Sname,String Cno);
    public abstract boolean dropCourse(String Sname,String Cno);
    public abstract List<Course> getStudentCourse(String Sname);

    public abstract List<Course> getAllCourse();
    public abstract List<Course> getSharedCourse();
}
