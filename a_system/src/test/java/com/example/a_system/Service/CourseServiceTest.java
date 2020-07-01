package com.example.a_system.Service;


import com.example.a_system.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @Test
    public void chooseCourseTest(){
        courseService.chooseCourse("01","B001");
    }
}
