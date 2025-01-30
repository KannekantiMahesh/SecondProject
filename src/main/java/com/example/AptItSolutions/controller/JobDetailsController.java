package com.example.AptItSolutions.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.JobDetails;
import com.example.AptItSolutions.service.JobDetailsService;

@RestController
@RequestMapping("/apijobdetails")
public class JobDetailsController {
	@Autowired
    private  JobDetailsService jobDetailsService;

   
	@PostMapping("/savejob")
	public ResponseEntity<String> createJobDetails(@RequestParam(required = false, value = "role") String role,
	                                               @RequestParam(required = false, value = "education") String education,
	                                               @RequestParam(required = false, value = "jobTitle") String jobTitle,
	                                               @RequestParam(required = false, value = "keySkills") String keySkills,
	                                               @RequestParam(required = false, value = "yearsOfExperience") String yearsOfExperience,
	                                               @RequestParam(required = false, value = "numberOfPositions") String numberOfPositions,
	                                               @RequestParam(required = false, value = "jobDescription") String jobDescription,
	                                               @RequestParam(required = false, value = "status") String statusString,
	 											@RequestParam(required = false, value = "userName") String userName)
	                                               {

	    // Create a new instance of JobDetails
	    JobDetails jobDetails = new JobDetails();

	    // Set jobDetails properties...
	    jobDetails.setUserName(userName);
	    jobDetails.setRole(role);
	    jobDetails.setEducation(education);
	    jobDetails.setJobTitle(jobTitle);
	    jobDetails.setKeySkills(keySkills);
	    jobDetails.setYearsOfExperience(yearsOfExperience);
	    jobDetails.setNumberOfPositions(numberOfPositions);
	    jobDetails.setJobDescription(jobDescription);

	    // Set the status to true for "Active"
	    jobDetails.setStatus(true);

	    // Set the creationDate using LocalDateTime.now()
	    jobDetails.setCreationDate(LocalDateTime.now());

	    // Parse lastDateToApplyString to LocalDateTime and set the last date to apply


	    // Save job details using the service
	    jobDetailsService.saveJobDetails(jobDetails);

	    // Return a ResponseEntity with a JSON response and HTTP status code
	    String jsonResponse = "{\"message\": \"Job details created successfully\"}";
	    return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}



    @GetMapping("/alljobs")
    public ResponseEntity<List<JobDetails>> getAllJobDetails() {
        List<JobDetails> jobDetailsList = jobDetailsService.getAllJobDetails();
        return new ResponseEntity<>(jobDetailsList, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<JobDetails> getJobDetailsById(@PathVariable("id") Long id) {
        JobDetails jobDetails = jobDetailsService.getJobDetailsById(id);
        if (jobDetails != null) {
            return new ResponseEntity<>(jobDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobupdating/{id}")
    public ResponseEntity<JobDetails> updateJobDetails(@PathVariable Long id,
            @RequestParam(required = false, value = "role") String role,
            @RequestParam(required = false, value = "education") String education,
            @RequestParam(required = false, value = "jobTitle") String jobTitle,
            @RequestParam(required = false, value = "keySkills") String keySkills,
            @RequestParam(required = false, value = "yearsOfExperience") String yearsOfExperience,
            @RequestParam(required = false, value = "numberOfPositions") String numberOfPositions,
            @RequestParam(required = false, value = "jobDescription") String jobDescription,
            @RequestParam(required = false, value = "status") String statusString,
            @RequestParam(required = false, value = "userName") String userName) {

        JobDetails existingJobDetails = jobDetailsService.getJobDetailsById(id);

        if (existingJobDetails != null) {
            // Set the values from the request parameters to the existing job details
            existingJobDetails.setUserName(userName);
            existingJobDetails.setRole(role);
            existingJobDetails.setEducation(education);
            existingJobDetails.setJobTitle(jobTitle);
            existingJobDetails.setKeySkills(keySkills);
            existingJobDetails.setYearsOfExperience(yearsOfExperience);
            existingJobDetails.setNumberOfPositions(numberOfPositions);
            boolean status = Boolean.parseBoolean(statusString);
            existingJobDetails.setStatus(status);
            existingJobDetails.setJobDescription(jobDescription);

            // Update the existing entity
            JobDetails updatedJobDetails = jobDetailsService.updateJobApplication(id, existingJobDetails);

            return new ResponseEntity<>(updatedJobDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






    @DeleteMapping("/deletejob/{id}")
    public ResponseEntity<HttpStatus> deleteJobDetails(@PathVariable("id") Long id) {
        JobDetails jobDetails = jobDetailsService.getJobDetailsById(id);
        if (jobDetails != null) {
            jobDetailsService.deleteJobDetails(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}