package com.example.a_system.dao.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
    //管理员操作
    public abstract boolean addCourse();
    public abstract boolean deleteCourse();
    public abstract boolean updateCourse();
    //学生操作
    public abstract boolean chooseCourse();
    public abstract boolean dropCourse();
    public abstract void getStudentCourse();

    public abstract void getAllCourse();
}
