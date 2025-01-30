package com.example.AptItSolutions.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String role;
    private String education;
    private String jobTitle;
    private String keySkills;
    private String yearsOfExperience;
    private String numberOfPositions;

    @Column(columnDefinition="longblob")
    private String jobDescription;
    
    private Boolean status;

    private LocalDateTime creationDate;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getNumberOfPositions() {
		return numberOfPositions;
	}

	public void setNumberOfPositions(String numberOfPositions) {
		this.numberOfPositions = numberOfPositions;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public JobDetails(Long id, String userName, String role, String education, String jobTitle, String keySkills,
			String yearsOfExperience, String numberOfPositions, String jobDescription, Boolean status,
			LocalDateTime creationDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.role = role;
		this.education = education;
		this.jobTitle = jobTitle;
		this.keySkills = keySkills;
		this.yearsOfExperience = yearsOfExperience;
		this.numberOfPositions = numberOfPositions;
		this.jobDescription = jobDescription;
		this.status = status;
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "JobDetails [id=" + id + ", userName=" + userName + ", role=" + role + ", education=" + education
				+ ", jobTitle=" + jobTitle + ", keySkills=" + keySkills + ", yearsOfExperience=" + yearsOfExperience
				+ ", numberOfPositions=" + numberOfPositions + ", jobDescription=" + jobDescription + ", status="
				+ status + ", creationDate=" + creationDate + "]";
	}

	public JobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}

