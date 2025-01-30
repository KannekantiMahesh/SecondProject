package com.example.AptItSolutions.service;

import java.util.List;

import com.example.AptItSolutions.Entity.Project;

public interface ProjectService {
    List<Project> getAllProjects();
    Project createProject(Project project);
}
