package com.example.a_system.service;

import com.example.a_system.dao.Repository.CourseRepository;
import com.example.a_system.po.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public boolean addCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String share){
        return courseRepository.addCourse(Cno,Cname,place,teacher,credit,type,share);
    }

    public boolean deleteCourse(String Cno){
        return courseRepository.deleteCourse(Cno);
    }

    public boolean updateCourse(String Cno,String Cname,String place,String teacher,String credit,String type,String share){
        return courseRepository.updateCourse(Cno,Cname,place,teacher,credit,type,share);
    }

    public boolean chooseCourse(String Sno,String Cno){
        if(Cno.substring(0,1).equals("A"))          //选择本院系的课
            return courseRepository.chooseCourse(Sno,Cno);
        else{               //选择外院系的课
            //调用集成服务器

            return false;
        }
    }

    public boolean dropCourse(String Sno,String Cno){
        if(Cno.substring(0,1).equals("A"))          //退本院系的课
            return courseRepository.dropCourse(Sno,Cno);
        else{               //退外院系的课
            //调用集成服务器

            return false;
        }

    }

    public List<Course> getStudentCourse(String Sno){
        return courseRepository.getStudentCourse(Sno);
    }

    public List<Course> getAllCourse(){
        return courseRepository.getAllCourse();
    }

    public boolean getOtherCourses(String type){    //获取外院系的共享课程，type是外院B或C
        if(type.equals("B")){   //获取外院B的共享课程

            return false;
        }
        else if(type.equals("C")){      //获取外院C的共享课程

            return false;
        }
        return false;
    }


}
