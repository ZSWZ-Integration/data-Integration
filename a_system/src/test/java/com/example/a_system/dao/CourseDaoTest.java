package com.example.a_system.dao;

import com.example.a_system.dao.Repository.CourseRepository;
import com.example.a_system.po.Course.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getStudentCourseTest(){
        List<Course> courses=courseRepository.getStudentCourse("01");
        System.out.println(courses);
        System.out.println(courses.size());
    }

}
