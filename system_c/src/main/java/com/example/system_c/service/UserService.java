package com.example.system_c.service;

import com.example.system_c.dao.Repository.UserRepository;
import com.example.system_c.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Student login(String username, String password){
        return userRepository.login(username,password);
    }

}
