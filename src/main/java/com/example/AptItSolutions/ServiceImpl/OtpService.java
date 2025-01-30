package com.example.AptItSolutions.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class OtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String generateOtp() {
        // Generate a 6-digit numeric OTP
        return OptProvider.generateOtp();
    }

    public void sendOtpMail(String email, String otp) {
        try {
            // Create and send an email with the OTP
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(email);
            mailMessage.setText("Your one-time password is: " + otp);
            mailMessage.setSubject("APTITS Projects Verification");
            javaMailSender.send(mailMessage);
            System.err.println("Success");
        } catch (Exception e) {
            // Handle exceptions if email sending fails
            System.err.println("Failed to send OTP email: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private Map<String, String> otpStorage = new HashMap<>(); // Store OTPs temporarily (you might want to use a more persistent storage)
    
    public boolean verifyOtpEnquiryForm(String email, String otp) {
        // Retrieve stored OTP for the given email
    	System.err.print(otpStorage);
        String storedOtp = otpStorage.get(email);
        System.err.print(storedOtp);
        // Check if the entered OTP matches the stored OTP
        
        System.err.print(otp);
        
        boolean otpVerified = otp.equals(storedOtp);
        		System.err.print(otpVerified);
        // Clear the stored OTP (for security, you might want to clear it even if verification fails)
        otpStorage.remove(email);
   
        return otpVerified;
    }
    
    
    // Method to initiate the OTP verification process
    public void initiateOtpVerification(String email) {
        // Generate OTP
        String otp =  generateOtp();
  
        // Store OTP temporarily
        otpStorage.put(email, otp);
     otpStorage.entrySet().stream().forEach(store -> System.out.print(store.getKey() + " " + store.getValue()));
        // Send OTP by email
        sendOtpMail(email, otp);
    }

    
    
}