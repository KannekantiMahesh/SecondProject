package com.example.AptItSolutions.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.ContactDetails;
import com.example.AptItSolutions.Entity.RecieverEmails;
import com.example.AptItSolutions.service.ContactDetailsService;
import com.example.AptItSolutions.service.RecieverEmailsService;

@RestController
@RequestMapping("/api")
public class ContactDetailsController {

    @Autowired
    private ContactDetailsService contactDetailsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RecieverEmailsService recieverEmailsService;

    @PostMapping("/savingDetail")
    public ResponseEntity<?> saveContactDetails(
            @RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("serviceType") String serviceType) {
        try {
            // Create a ContactDetails object and set its properties
            ContactDetails contactDetails = new ContactDetails(null, name, phoneNumber, email, message, serviceType);

            // Save the contact details using the service
            ContactDetails savedContactDetails = contactDetailsService.saveContactDetails(contactDetails);

            // Get receiver emails from the database
            List<RecieverEmails> receiverEmails = recieverEmailsService.getAllRecieverEmails();

            // Construct the email body with all the fields
            String emailBody = String.format(
                    "Name: %s\n" +
                            "Phone Number: %s\n" +
                            "Email: %s\n" +
                            "Message: %s\n" +
                            "Service Type: %s\n",
                    name, phoneNumber, email, message, serviceType);

            // Send emails to receiver email addresses
            List<String> recipientEmails = new ArrayList<>();

            // Add additional email addresses
            List<String> additionalEmails = List.of(
                    // "info@aptits.com",
                    // "sridhar@aptits.com",
                    // "sai.srinivas@aptits.com"
            );

            recipientEmails.addAll(additionalEmails);

            for (RecieverEmails receiver : receiverEmails) {
                recipientEmails.add(receiver.getEmail());
            }

            // Send emails to all recipients
            for (String recipientEmail : recipientEmails) {
                emailService.sendEmail(recipientEmail, "Subject: Contact Form Submission", emailBody);
            }

            // Send confirmation email to the user
            String userConfirmationContent = "Thank you for submitting the Contact Form. Your form has been successfully submitted.";
            emailService.sendEmail(email, "Contact Form Registration Confirmation", userConfirmationContent);

            return new ResponseEntity<>(savedContactDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error or return a specific error response
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


	
	
	
    @GetMapping("/getallcontacts")
    public ResponseEntity<List<ContactDetails>> getAllContactDetails() {
        List<ContactDetails> contactDetailsList = contactDetailsService.getAllContactDetails();
        return new ResponseEntity<>(contactDetailsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDetails> getContactDetailsById(@PathVariable Long id) {
        ContactDetails contactDetails = contactDetailsService.getContactDetailsById(id);
        return new ResponseEntity<>(contactDetails, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDetails> updateContactDetails(
            @PathVariable Long id,
            @RequestBody ContactDetails updatedContactDetails) {
        ContactDetails contactDetails = contactDetailsService.updateContactDetails(id, updatedContactDetails);
        return new ResponseEntity<>(contactDetails, HttpStatus.OK);
    }

    @DeleteMapping("deleteed/{id}")
    public ResponseEntity<Void> deleteContactDetails(@PathVariable Long id) {
        contactDetailsService.deleteContactDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @PutMapping("/{id}/updateEmail")
    public ResponseEntity<ContactDetails> updateEmail(
            @PathVariable Long id,
            @RequestParam String newEmail) {

        // Retrieve the existing contact details
        ContactDetails contactDetails = contactDetailsService.getContactDetailsById(id);

        if (contactDetails != null) {
            // Save the old email for notification
            String oldEmail = contactDetails.getEmail();

            // Update the email in contact details
            contactDetails.setEmail(newEmail);

            // Save the updated contact details
            ContactDetails updatedContactDetails = contactDetailsService.updateContactDetails(id, contactDetails);

            // Notify the user of the email update
            emailService.sendEmailUpdateNotification(oldEmail, newEmail);

            return new ResponseEntity<>(updatedContactDetails, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}  
 