package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.User;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    public User login(String email, String password);

    

}
