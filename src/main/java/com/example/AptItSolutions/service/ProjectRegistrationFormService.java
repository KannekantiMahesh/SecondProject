package com.example.AptItSolutions.service;


import java.util.List;

import com.example.AptItSolutions.Entity.ProjectRegistrationForm;

public interface ProjectRegistrationFormService {
    ProjectRegistrationForm save(ProjectRegistrationForm form);
    List<ProjectRegistrationForm> getAll();
    ProjectRegistrationForm getById(String id);
    void deleteById(String id);
}
