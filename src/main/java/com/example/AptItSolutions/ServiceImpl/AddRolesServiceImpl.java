package com.example.AptItSolutions.ServiceImpl;

import java.util.List;
import java.util.Optional;

//AddRolesServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.AddRoles;
import com.example.AptItSolutions.Entity.TrackerAddRoles;
import com.example.AptItSolutions.Repo.AddRolesRepository;
import com.example.AptItSolutions.Repo.TrackerAddRolesRepository;
import com.example.AptItSolutions.service.AddRolesService;

@Service
public class AddRolesServiceImpl implements AddRolesService {

 @Autowired
 private AddRolesRepository addRolesRepository;
 
 @Autowired
 private TrackerAddRolesRepository trackerAddRolesRepository;

 @Override
 public List<AddRoles> getAllRoles() {
     return addRolesRepository.findAll();
 }

 @Override
 public AddRoles getRoleById(Long id) {
     return addRolesRepository.findById(id).orElse(null);
 }

 @Override
 public AddRoles createRole(AddRoles role) {
     return addRolesRepository.save(role);
 }

 @Override
 public AddRoles updateRole(Long id, AddRoles role) {
     AddRoles existingRole = addRolesRepository.findById(id).orElse(null);
     if (existingRole != null) {
         // Update the fields as needed
         existingRole.setRole(role.getRole());
         existingRole.setCreatedBy(role.getCreatedBy());

         return addRolesRepository.save(existingRole);
     }
     return null; // Handle not found case
 }



 
 public AddRoles updateAddRoles(Long roleId, AddRoles updatedAddRoles) {
     TrackerAddRoles trackerAddRoles = new TrackerAddRoles();
     Optional<AddRoles> existingAddRolesOptional = addRolesRepository.findById(roleId);

     if (existingAddRolesOptional.isPresent()) {
         AddRoles existingAddRoles = existingAddRolesOptional.get();

         if (!existingAddRoles.getRole().equals(updatedAddRoles.getRole())) {
             trackerAddRoles.setRoleId(existingAddRoles.getId());
             trackerAddRoles.setExistingRole(existingAddRoles.getRole());
             trackerAddRoles.setNewRole(updatedAddRoles.getRole());
         }
         if (!existingAddRoles.getCreatedBy().equals(updatedAddRoles.getCreatedBy())) {
             trackerAddRoles.setExistingCreatedBy(existingAddRoles.getCreatedBy());
             trackerAddRoles.setNewCreatedBy(updatedAddRoles.getCreatedBy());
         }
         if (!existingAddRoles.getCreationDate().equals(updatedAddRoles.getCreationDate())) {
             trackerAddRoles.setExistingCreationDate(existingAddRoles.getCreationDate());
             trackerAddRoles.setNewCreationDate(updatedAddRoles.getCreationDate());
         }

         trackerAddRolesRepository.save(trackerAddRoles);

         existingAddRoles.setRole(updatedAddRoles.getRole());
         existingAddRoles.setCreatedBy(updatedAddRoles.getCreatedBy());
         existingAddRoles.setCreationDate(updatedAddRoles.getCreationDate());

         return addRolesRepository.save(existingAddRoles);
     }

     return null;
 }

 
 
 
 
 
 @Override
 public void deleteRole(Long id) {
     addRolesRepository.deleteById(id);
 }

 // Add other methods as needed
}
