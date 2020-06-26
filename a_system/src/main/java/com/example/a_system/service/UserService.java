package com.example.a_system.service;

import com.example.a_system.dao.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String login(String username,String password){
        return userRepository.login(username,password);
    }

}
