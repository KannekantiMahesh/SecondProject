package com.example.AptItSolutions.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.Login;
import com.example.AptItSolutions.Repo.LoginRepository;
import com.example.AptItSolutions.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository userRepository;

    @Override
    public Login saveUser(Login user) {
        // You can add validation logic here if needed
        return userRepository.save(user);
    }

    @Override
    public List<Login> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Login login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
