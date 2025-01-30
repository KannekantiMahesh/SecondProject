package com.example.AptItSolutions.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String projectId;

    private String projectType;
    private String location;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectType=" + projectType + ", location=" + location + "]";
	}
	public Project(String projectId, String projectType, String location) {
		super();
		this.projectId = projectId;
		this.projectType = projectType;
		this.location = location;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
