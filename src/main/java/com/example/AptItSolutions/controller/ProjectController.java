package com.example.AptItSolutions.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AptItSolutions.Entity.Project;
import com.example.AptItSolutions.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<Project> createProject(@PathVariable String projectId, @RequestBody Project project) {
        if (!projectId.equals("mahesh")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        project.setProjectId(projectId);
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }
}
