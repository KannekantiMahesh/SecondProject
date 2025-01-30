package com.example.AptItSolutions.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class tblUserExamReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Long examId;
    private String category;
    private String topic;
    private int totalQuestions;
    private int correctAnswers;
    private Date startDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int duration;
    private int retakeExamCount;
    private boolean isActive;
    private boolean isDeleted;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;
    private LocalDateTime modifiedOn;
    private double marksPercentage;

    // Getters and setters, constructor, and other methods

}
