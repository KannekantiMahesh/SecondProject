package com.example.AptItSolutions.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrackerJobDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;
    private Long jobId;
    private String userName;
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String existingRole;
    private String newRole;
    private String existingEducation;
    private String newEducation;
    private String existingJobTitle;
    private String newJobTitle;
    private String existingKeySkills;
    private String newKeySkills;
    private String existingYearsOfExperience;
    private String newYearsOfExperience;
    private String existingNumberOfPositions;
    private String newNumberOfPositions;
    @Column(columnDefinition="longblob")
    private String existingJobDescription;
    @Column(columnDefinition="longblob")
    private String newJobDescription;
    private Boolean existingStatus;
    private Boolean newStatus;
    private LocalDateTime existingCreationDate;
    private LocalDateTime newCreationDate;
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getExistingRole() {
		return existingRole;
	}
	public void setExistingRole(String existingRole) {
		this.existingRole = existingRole;
	}
	public String getNewRole() {
		return newRole;
	}
	public void setNewRole(String newRole) {
		this.newRole = newRole;
	}
	public String getExistingEducation() {
		return existingEducation;
	}
	public void setExistingEducation(String existingEducation) {
		this.existingEducation = existingEducation;
	}
	public String getNewEducation() {
		return newEducation;
	}
	public void setNewEducation(String newEducation) {
		this.newEducation = newEducation;
	}
	public String getExistingJobTitle() {
		return existingJobTitle;
	}
	public void setExistingJobTitle(String existingJobTitle) {
		this.existingJobTitle = existingJobTitle;
	}
	public String getNewJobTitle() {
		return newJobTitle;
	}
	public void setNewJobTitle(String newJobTitle) {
		this.newJobTitle = newJobTitle;
	}
	public String getExistingKeySkills() {
		return existingKeySkills;
	}
	public void setExistingKeySkills(String existingKeySkills) {
		this.existingKeySkills = existingKeySkills;
	}
	public String getNewKeySkills() {
		return newKeySkills;
	}
	public void setNewKeySkills(String newKeySkills) {
		this.newKeySkills = newKeySkills;
	}
	public String getExistingYearsOfExperience() {
		return existingYearsOfExperience;
	}
	public void setExistingYearsOfExperience(String existingYearsOfExperience) {
		this.existingYearsOfExperience = existingYearsOfExperience;
	}
	public String getNewYearsOfExperience() {
		return newYearsOfExperience;
	}
	public void setNewYearsOfExperience(String newYearsOfExperience) {
		this.newYearsOfExperience = newYearsOfExperience;
	}
	public String getExistingNumberOfPositions() {
		return existingNumberOfPositions;
	}
	public void setExistingNumberOfPositions(String existingNumberOfPositions) {
		this.existingNumberOfPositions = existingNumberOfPositions;
	}
	public String getNewNumberOfPositions() {
		return newNumberOfPositions;
	}
	public void setNewNumberOfPositions(String newNumberOfPositions) {
		this.newNumberOfPositions = newNumberOfPositions;
	}
	public String getExistingJobDescription() {
		return existingJobDescription;
	}
	public void setExistingJobDescription(String existingJobDescription) {
		this.existingJobDescription = existingJobDescription;
	}
	public String getNewJobDescription() {
		return newJobDescription;
	}
	public void setNewJobDescription(String newJobDescription) {
		this.newJobDescription = newJobDescription;
	}
	public Boolean getExistingStatus() {
		return existingStatus;
	}
	public void setExistingStatus(Boolean existingStatus) {
		this.existingStatus = existingStatus;
	}
	public Boolean getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(Boolean newStatus) {
		this.newStatus = newStatus;
	}
	public LocalDateTime getExistingCreationDate() {
		return existingCreationDate;
	}
	public void setExistingCreationDate(LocalDateTime existingCreationDate) {
		this.existingCreationDate = existingCreationDate;
	}
	public LocalDateTime getNewCreationDate() {
		return newCreationDate;
	}
	public void setNewCreationDate(LocalDateTime newCreationDate) {
		this.newCreationDate = newCreationDate;
	}
	public TrackerJobDetails(Long sno, String userName,Long jobId, String existingRole, String newRole, String existingEducation,
			String newEducation, String existingJobTitle, String newJobTitle, String existingKeySkills,
			String newKeySkills, String existingYearsOfExperience, String newYearsOfExperience,
			String existingNumberOfPositions, String newNumberOfPositions, String existingJobDescription,
			String newJobDescription, Boolean existingStatus, Boolean newStatus, LocalDateTime existingCreationDate,
			LocalDateTime newCreationDate) {
		super();
		this.sno = sno;
		this.userName = userName;
		this.jobId = jobId;
		this.existingRole = existingRole;
		this.newRole = newRole;
		this.existingEducation = existingEducation;
		this.newEducation = newEducation;
		this.existingJobTitle = existingJobTitle;
		this.newJobTitle = newJobTitle;
		this.existingKeySkills = existingKeySkills;
		this.newKeySkills = newKeySkills;
		this.existingYearsOfExperience = existingYearsOfExperience;
		this.newYearsOfExperience = newYearsOfExperience;
		this.existingNumberOfPositions = existingNumberOfPositions;
		this.newNumberOfPositions = newNumberOfPositions;
		this.existingJobDescription = existingJobDescription;
		this.newJobDescription = newJobDescription;
		this.existingStatus = existingStatus;
		this.newStatus = newStatus;
		this.existingCreationDate = existingCreationDate;
		this.newCreationDate = newCreationDate;
	}
	@Override
	public String toString() {
		return "TrackerJobDetails [sno=" + sno + ", jobId=" + jobId + ", existingRole=" + existingRole + ", newRole="
				+ newRole + ", existingEducation=" + existingEducation + ", newEducation=" + newEducation
				+ ", existingJobTitle=" + existingJobTitle + ", newJobTitle=" + newJobTitle + ", existingKeySkills="
				+ existingKeySkills + ", newKeySkills=" + newKeySkills + ", existingYearsOfExperience="
				+ existingYearsOfExperience + ", newYearsOfExperience=" + newYearsOfExperience
				+ ", existingNumberOfPositions=" + existingNumberOfPositions + ", newNumberOfPositions="
				+ newNumberOfPositions + ", existingJobDescription=" + existingJobDescription + ", newJobDescription="
				+ newJobDescription + ", existingStatus=" + existingStatus + ", newStatus=" + newStatus
				+ ", existingCreationDate=" + existingCreationDate + ", newCreationDate=" + newCreationDate + "]";
	}
	public TrackerJobDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

  
    
    
    
    
}