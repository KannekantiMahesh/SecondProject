package com.example.AptItSolutions.ServiceImpl;

import java.util.Random;

public class OptProvider {

    public static String generateOtp() {
        // Using random method
        Random rndm_method = new Random();

        // Generate a 6-digit OTP
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            // Use of nextInt() to generate a random number between 0 and 9 (inclusive)
            otp.append(rndm_method.nextInt(10));
        }

        // Convert StringBuilder to String and return the OTP
        return otp.toString();
    }

    public static void main(String[] args) {
        String otp = generateOtp();
        System.out.println("Generated OTP: " + otp);
    }
}	