package com.example.AptItSolutions.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.User;
import com.example.AptItSolutions.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

 @Autowired
 private UserService userService;

 @PostMapping("/regi")
 public User registerUser(
         @RequestParam String userName,
         @RequestParam String email,
         @RequestParam String contactNumber,
         @RequestParam String password
 ) {
     User user = new User();
     user.setUserName(userName);
     user.setEmail(email);
     user.setContactNumber(contactNumber);
     user.setPassword(password);

     return userService.saveUser(user);
 }


 
 @PostMapping("/logins")
 public ResponseEntity<User> login(@RequestBody User loginForm) {
	 User loginResponse = userService.login(loginForm.getEmail(), loginForm.getPassword());
  if (loginResponse != null) {
   return ResponseEntity.ok(loginResponse);
  } else {
   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
 }
 

 
 @GetMapping
 public List<User> getAllUsers() {
     return userService.getAllUsers();
 }
}
