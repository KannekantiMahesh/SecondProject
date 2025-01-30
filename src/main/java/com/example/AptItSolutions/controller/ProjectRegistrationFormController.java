package com.example.AptItSolutions.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.AptItSolutions.Entity.ProjectRegistrationForm;
import com.example.AptItSolutions.ServiceImpl.OtpService;
import com.example.AptItSolutions.service.ProjectRegistrationFormService;
import com.example.AptItSolutions.service.RecieverEmailsService;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectRegistrationFormController {

    @Autowired
    private ProjectRegistrationFormService service;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RecieverEmailsService recieverEmailsService;
    
    
    
    @Autowired
    private OtpService otpService;
 

    @Autowired
    public ProjectRegistrationFormController(ProjectRegistrationFormService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
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
            // Create a ProjectRegistrationForm object and set its properties
            ProjectRegistrationForm form = new ProjectRegistrationForm();
            form.setName(name);
            form.setEmail(email);
            form.setMobile(mobile);
            form.setCollegename(collegename);
            form.setCollegeid(collegeid);
            form.setCountry(country);
            form.setState(state);
            form.setCity(city);
            form.setAnyquiries(anyquiries);
            form.setChoosedomain(choosedomain);
            form.setTimeduration(timeduration);
            form.setAnyquiries(anyquiries);

            // Convert and set the byte arrays from MultipartFile if certificates are present
            if (certificates != null) {
                try {
                    form.setCertificates(certificates.getBytes());
                } catch (IOException e) {
                    return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            // Save the form with a custom ID
            ProjectRegistrationForm savedForm = service.save(form);

            System.out.println(savedForm.getProRegId());

            // Generate and set the link
            String saveLink = "http://localhost:4200/projects/" + savedForm.getProRegId();
            form.setLink(saveLink);

            // Save the form with the link
            ProjectRegistrationForm updatedForm = service.save(form);

         // Construct the email content without table format
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
                    name, updatedForm.getProRegId(), name, email, mobile, choosedomain, timeduration, collegename, city);

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
                        name, updatedForm.getProRegId(), name, email, mobile, choosedomain, timeduration, collegename, city);

                emailService.sendEmail(additionalEmail, "Project Registration", additionalEmailContent);
            }




            // Create a response map including proRegId
            Map<String, Object> response = new HashMap<>();
            response.put("proRegId", updatedForm.getProRegId());
            response.put("message", "Form submitted successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the error or return a specific error response
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



 
 // first send mail 
    @PostMapping("/send-otp-mail")
    public ResponseEntity<Map<String, String>> sendOPTMailEnquiry(@RequestParam String email) {
        try {
            // Call the service to initiate OTP verification process and send mail
        	otpService.initiateOtpVerification(email);

            // Return success response
            Map<String, String> response = new HashMap<>();
            response.put("message", "OTP mail sent successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return error response if an exception occurs
            Map<String, String> response = new HashMap<>();
            response.put("error", "Failed to send OTP mail.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    
    
    // verify the give otp with the stored otp(already sent otp through mail)
    @PostMapping("/verifyotpenquiry")
    public ResponseEntity<Map<String, String>> verifyOtpEnquiryForm(
            @RequestParam String otp,
            @RequestParam String email 
    ) {
        Map<String, String> response = new HashMap<>();
        	
        // Verify the entered OTP
        boolean otpVerified = otpService.verifyOtpEnquiryForm(email, otp);

        if (otpVerified) {
            response.put("message", "OTP verified. You can now access the application.");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid OTP.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    
    
    
    

    @GetMapping("/all")
    public List<ProjectRegistrationForm> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProjectRegistrationForm getById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping("/dele/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

}
