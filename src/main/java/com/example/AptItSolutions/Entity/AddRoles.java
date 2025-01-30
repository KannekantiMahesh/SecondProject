package com.example.AptItSolutions.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "add_roles")
public class AddRoles {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String role;
 private String createdBy;
 private LocalDate creationDate;
 
 
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public LocalDate getCreationDate() {
	return creationDate;
}
public void setCreationDate(LocalDate creationDate) {
	this.creationDate = creationDate;
}
public AddRoles(Long id, String role, String createdBy, LocalDate creationDate) {
	super();
	this.id = id;
	this.role = role;
	this.createdBy = createdBy;
	this.creationDate = creationDate;
}
@Override
public String toString() {
	return "AddRoles [id=" + id + ", role=" + role + ", createdBy=" + createdBy + ", creationDate=" + creationDate
			+ "]";
}
public AddRoles() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
 
}
