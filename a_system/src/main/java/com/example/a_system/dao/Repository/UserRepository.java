package com.example.a_system.dao.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public abstract String login(String username,String password);
}
