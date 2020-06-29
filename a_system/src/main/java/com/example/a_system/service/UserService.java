package com.example.a_system.service;

import com.example.a_system.dao.Repository.UserRepository;
import com.example.a_system.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public StudentVO login(String username, String password){
        return userRepository.login(username,password);
    }

}
