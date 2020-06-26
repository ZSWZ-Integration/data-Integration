package com.example.a_system.dao;

import com.example.a_system.dao.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void loginTest(){
        System.out.println(userRepository.login("100","123456"));
    }

}
