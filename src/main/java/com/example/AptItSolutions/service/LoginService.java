package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.Login;

public interface LoginService {

    Login saveUser(Login user);

    List<Login> getAllUsers();

    Login login(String email, String password);
}
