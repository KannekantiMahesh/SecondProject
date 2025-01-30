package com.example.AptItSolutions.service;

//AddRolesService.java
import java.util.List;

import com.example.AptItSolutions.Entity.AddRoles;

public interface AddRolesService {
 List<AddRoles> getAllRoles();
 AddRoles getRoleById(Long id);
 AddRoles createRole(AddRoles role);
 AddRoles updateRole(Long id, AddRoles role);
 void deleteRole(Long id);
 // Add other methods as needed
}
