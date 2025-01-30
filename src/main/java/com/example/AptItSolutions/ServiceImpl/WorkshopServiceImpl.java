package com.example.AptItSolutions.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.WorkshopReg;
import com.example.AptItSolutions.Repo.WorkshopsRepo;
import com.example.AptItSolutions.service.WorkshopService;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    @Autowired
    private WorkshopsRepo workshopsRepo;

    @Override
    public WorkshopReg save(WorkshopReg form) {
        // Generate custom ID
        generateCustomId(form);

        // Save the WorkshopReg using the repository
        return workshopsRepo.save(form);
    }

    @Override
    public List<WorkshopReg> getAll() {
        return workshopsRepo.findAll();
    }

    @Override
    public WorkshopReg getById(String id) {
        return workshopsRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        workshopsRepo.deleteById(id);
    }

    private void generateCustomId(WorkshopReg form) {
        try {
            List<WorkshopReg> existingForms = workshopsRepo.findAll();
            long maxSequenceNumber = 0;

            if (existingForms != null && !existingForms.isEmpty()) {
                for (WorkshopReg existingForm : existingForms) {
                    String workRegId = existingForm.getWorkRegId();
                    if (workRegId.matches("[A-Z]{3}\\d{7}")) {
                        // Extract the numeric part
                        long sequenceNumber = Long.parseLong(workRegId.substring(6));

                        if (sequenceNumber > maxSequenceNumber) {
                            maxSequenceNumber = sequenceNumber;
                        }
                    }
                }
            }

            long sequenceNumber = maxSequenceNumber + 1;

            // Get the first three letters of the college name (uppercase)
            String collegeCode = form.getCollegename().substring(0, Math.min(form.getCollegename().length(), 3)).toUpperCase();

            // Get the current month and year in the format "MMyy"
            String currentMonthYear = LocalDate.now().format(DateTimeFormatter.ofPattern("MMyy"));

            // Format the custom ID
            String customId = String.format("%s%s%03d", collegeCode, currentMonthYear, sequenceNumber);

            // Check if the generated custom ID already exists
            while (workshopsRepo.existsByWorkRegId(customId)) {
                sequenceNumber++;
                customId = String.format("%s%s%03d", collegeCode, currentMonthYear, sequenceNumber);
            }

            form.setWorkRegId(customId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}