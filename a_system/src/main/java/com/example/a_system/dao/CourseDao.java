package com.example.a_system.dao;

import com.example.a_system.dao.Repository.CourseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao implements CourseRepository {

    @Override
    public boolean addCourse() {
        return false;
    }

    @Override
    public boolean deleteCourse() {
        return false;
    }

    @Override
    public boolean updateCourse() {
        return false;
    }

    @Override
    public boolean chooseCourse() {
        return false;
    }

    @Override
    public boolean dropCourse() {
        return false;
    }

    @Override
    public void getStudentCourse() {

    }

    @Override
    public void getAllCourse() {

    }
}
