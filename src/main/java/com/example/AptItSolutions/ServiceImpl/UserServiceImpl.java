package com.example.AptItSolutions.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.User;
import com.example.AptItSolutions.Repo.UserRepository;
import com.example.AptItSolutions.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // You can add validation logic here if needed
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    



    @Override
    public User login(String email, String password) {
    	  return userRepository.findByEmailAndPassword(email, password);
    	 }


}