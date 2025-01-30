package com.example.AptItSolutions.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.AddRoles;
import com.example.AptItSolutions.service.AddRolesService;

@RestController
@RequestMapping("/api/addroles")
public class AddRolesController {

    @Autowired
    private AddRolesService addRolesService;
    
    

    @GetMapping("/getroles")
    public List<AddRoles> getAllRoles() {
        return addRolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddRoles> getRoleById(@PathVariable Long id) {
        AddRoles role = addRolesService.getRoleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<AddRoles> createRole(
            @RequestParam String role,
            @RequestParam String createdBy) {

        AddRoles newRole = new AddRoles();
        newRole.setRole(role);
        newRole.setCreatedBy(createdBy);

        // Set the creation date to the current date on the server
        newRole.setCreationDate(LocalDate.now());

        AddRoles createdRole = addRolesService.createRole(newRole);
        return ResponseEntity.ok(createdRole);
    }


 @PutMapping("/{id}")
 public ResponseEntity<AddRoles> updateRole(@PathVariable Long id, @RequestBody AddRoles role) {
     AddRoles updatedRole = addRolesService.updateRole(id, role);
     if (updatedRole != null) {
         return ResponseEntity.ok(updatedRole);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
     addRolesService.deleteRole(id);
     return ResponseEntity.noContent().build();
 }

 // Add other CRUD operations as needed
}
