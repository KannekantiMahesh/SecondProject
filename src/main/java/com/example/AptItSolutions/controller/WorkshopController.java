package com.example.AptItSolutions.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.AptItSolutions.Entity.WorkshopReg;
import com.example.AptItSolutions.service.RecieverEmailsService;
import com.example.AptItSolutions.service.WorkshopService;

@RestController
@RequestMapping("/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @Autowired
    private RecieverEmailsService recieverEmailsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping("/home")
    public ResponseEntity<?> saveWorkshopReg(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String mobile,
            @RequestParam(required = true) String collegename,
            @RequestParam(required = false) String collegeid,
            @RequestParam(required = true) String country,
            @RequestParam(required = true) String state,
            @RequestParam(required = true) String city,
            @RequestParam(required = true) String choosedomain,
            @RequestParam(required = true) String timeduration,
            @RequestParam(required = false) String anyquiries,
            @RequestParam(required = false) MultipartFile certificates) {

        try {
            // Create a WorkshopReg object and set its properties
            WorkshopReg form = new WorkshopReg();
            form.setName(name);
            form.setEmail(email);
            form.setMobile(mobile);
            form.setCollegename(collegename);
            form.setCollegeid(collegeid);
            form.setCountry(country);
            form.setState(state);
            form.setCity(city);
            form.setChoosedomain(choosedomain);
            form.setTimeduration(timeduration);
            form.setAnyquiries(anyquiries);

            // Convert and set the byte arrays from MultipartFile
            try {
                if (certificates != null) {
                    form.setCertificates(certificates.getBytes());
                }

            } catch (IOException e) {
                // Handle exception as needed
                return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            // Save the form with a custom ID
            WorkshopReg savedForm = workshopService.save(form);

            String userEmailContent = String.format(
                    "Dear %s,\n\n" +
                    		 "Congratulations for Successfully Registered.\n\n" + // Bold text with asterisks
                            "Please find below the details:\n\n" +
                            "Registration ID            : %s\n" +
                            "Name                          : %s\n" +
                            "EMail                         : %s\n" +
                            "Mobile                        : %s\n" +
                            "Domain                       : %s\n" +
                            "Time Duration (Months) : %s\n" +
                            "College Name               : %s\n" +
                            "City                            : %s\n\n" +
                            "You will receive Program Schedule to your email ID.\n" +
                            "(Please verify your Spam/Bin/Trash folders)\n\n" +
                            "Student Coordinator - APT IT Solutions",
                    name, savedForm.getWorkRegId(), name, email, mobile, choosedomain, timeduration, collegename, city);

            // Send email to the user's provided email
            emailService.sendEmail(email, "Project Registration", userEmailContent);

            // Send emails to additional recipients
            List<String> additionalEmails = List.of(  
            		"info@aptits.comcom",
                  "sridhar@aptits.com",
                  "sai.srinivas@aptits.com"
                  
            		
            		);
            
            

            // Send an email with additional information to each recipient
            for (String additionalEmail : additionalEmails) {
                String additionalEmailContent = String.format(
                        "Dear %s,\n\n" +
                        		 "Congratulations for Successfully Registered.\n\n" + // Bold text with asterisks
                                "Please find below the details:\n\n" +
                                "Registration ID            : %s\n" +
                                "Name                          : %s\n" +
                                "EMail                         : %s\n" +
                                "Mobile                        : %s\n" +
                                "Domain                       : %s\n" +
                                "Time Duration (Months) : %s\n" +
                                "College Name                : %s\n" +
                                "City                            : %s\n\n" +
                                "You will receive Program Schedule to your email ID.\n" +
                                "(Please verify your Spam/Bin/Trash folders)\n\n" +
                                "Student Coordinator - APT IT Solutions",
                        name, savedForm.getWorkRegId(), name, email, mobile, choosedomain, timeduration, collegename, city);

                emailService.sendEmail(additionalEmail, "Project Registration", additionalEmailContent);
            }

            // Create a response map including workRegId
            Map<String, Object> response = new HashMap<>();
            response.put("workRegId", savedForm.getWorkRegId());
            response.put("message", "Form submitted successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the error or return a specific error response
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getworks")
    public List<WorkshopReg> getAll() {
        return workshopService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkshopReg> getById(@PathVariable String id) {
        WorkshopReg workshopReg = workshopService.getById(id);
        return workshopReg != null ?
                new ResponseEntity<>(workshopReg, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delit/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        workshopService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // You can add more methods and customize the mappings as needed
}

