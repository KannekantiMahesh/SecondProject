package com.example.AptItSolutions.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.Project;
import com.example.AptItSolutions.Repo.ProjectRepository;
import com.example.AptItSolutions.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(Project project) {
        // Generate custom project ID with the sequence of current year and month
        String projectId = generateProjectId();

        project.setProjectId(projectId);

        return projectRepository.save(project);
    }

    private String generateProjectId() {
        LocalDate currentDate = LocalDate.now();
        String yearMonth = currentDate.format(DateTimeFormatter.ofPattern("yyyyMM"));
        return "PRJ-" + yearMonth + "-" + generateRandomNumber();
    }

    private String generateRandomNumber() {
        // Implement your logic to generate a random number
        return "0001"; // For simplicity, just returning a static number
    }
}
