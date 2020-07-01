package com.example.a_system.dao.Repository;

import com.example.a_system.po.Course.Choice;

import com.example.a_system.vo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {
    //管理员操作
    public abstract boolean addCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String isShared);
    public abstract boolean deleteCourse(String Cno);
    public abstract boolean updateCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String isShared);
    //学生操作
    public abstract boolean chooseCourse(String Sno,String Cno);
    public abstract boolean dropCourse(String Sno,String Cno);
    public abstract List<com.example.a_system.po.Course.CoursePO> getStudentCourse(String Sno);

    public abstract List<com.example.a_system.po.Course.CoursePO> getAllCourse();
    public abstract List<Course> getSharedCourse();
    public abstract int getACoursesNum();

    public abstract Choice getChoiceInfo(String sno, String cno);
}
