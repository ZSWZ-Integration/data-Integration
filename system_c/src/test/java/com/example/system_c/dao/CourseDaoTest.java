package com.example.system_c.dao;

import com.example.system_c.dao.Repository.CourseRepository;
import com.example.system_c.po.Course.CoursePO;
import com.example.system_c.vo.Course;
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
    public void CoursesTest(){
//        courseRepository.addCourse("C11","通识课","周沛辰","3","0");
//
//        courseRepository.updateCourse("C11","通识课111","周沛辰2","3","0");
//        courseRepository.deleteCourse("C11");
//        courseRepository.chooseCourse("0001","C01");
//        courseRepository.chooseCourse("0001","C02");
//        courseRepository.chooseCourse("0002","C01");
//        courseRepository.chooseCourse("0003","C03");
        //courseRepository.dropCourse("0003","C03");
        List<CoursePO> coursePOS=courseRepository.getStudentCourse("0001");
        System.out.println("size is "+coursePOS.size());
        List<CoursePO> courses=courseRepository.getAllCourse();
        System.out.println("--------");
        List<Course> course=courseRepository.getSharedCourse();
        System.out.println("--------");


    }


}
