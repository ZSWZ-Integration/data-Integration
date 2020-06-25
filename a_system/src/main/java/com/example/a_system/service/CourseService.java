package com.example.a_system.service;

import com.example.a_system.dao.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public boolean addCourse(){
        return courseRepository.addCourse();
    }

    public boolean deleteCourse(){
        return courseRepository.deleteCourse();
    }

    public boolean updateCourse(){
        return courseRepository.updateCourse();
    }

    public boolean chooseCourse(){
        return courseRepository.chooseCourse();
    }

    public boolean dropCourse(){
        return courseRepository.dropCourse();
    }

    public void GetStudentCourse(){
        courseRepository.getStudentCourse();
    }

    public void GetAllCourse(){
        courseRepository.getAllCourse();
    }

}
