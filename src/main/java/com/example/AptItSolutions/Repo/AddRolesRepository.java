package com.example.AptItSolutions.Repo;

//AddRolesRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AptItSolutions.Entity.AddRoles;

public interface AddRolesRepository extends JpaRepository<AddRoles, Long> {
 // You can add custom query methods if needed
}
