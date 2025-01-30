package com.example.AptItSolutions.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AptItSolutions.Entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByEmailAndPassword(String email, String password);
}
