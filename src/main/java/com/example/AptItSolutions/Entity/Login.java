package com.example.AptItSolutions.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;
    private String contactNumber;
    private String password;
    private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Login(Long id, String userName, String email, String contactNumber, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", userName=" + userName + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", password=" + password + ", role=" + role + "]";
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    

}
