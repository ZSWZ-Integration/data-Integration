package com.example.system_c.dao;

import com.example.system_c.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void userDaoTests(){
        Student s=userDao.login("170001","000000");
        Student ss=userDao.login("170001","000010");
        boolean b=userDao.addStudent("170099","nopassword","A01","周沛辰","男");
        Student sss=userDao.getStudentInfo("A01");
        boolean bb=userDao.deleteStudent("A01");

    }

}
