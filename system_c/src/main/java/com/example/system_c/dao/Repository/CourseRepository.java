package com.example.system_c.dao.Repository;

import com.example.system_c.po.Course.Choice;
import com.example.system_c.po.Course.Course;

import com.example.system_c.vo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {
    //管理员操作
    public abstract boolean addCourse(String No,String Name,String Teacher,String Credit,String isShare);
    public abstract boolean deleteCourse(String No);
    public abstract boolean updateCourse(String No,String Name,String Teacher,String Credit,String isShare);
    //学生操作
    public abstract boolean chooseCourse(String Sno,String Cno);
    public abstract boolean dropCourse(String Sno,String Cno);
    public abstract List<Course> getStudentCourse(String Sno);

    public abstract List<Course> getAllCourse();
    public abstract List<Course> getSharedCourse();
    public abstract int getCCoursesNum();

    public abstract Choice getChoiceInfo(String sno, String cno);
}
