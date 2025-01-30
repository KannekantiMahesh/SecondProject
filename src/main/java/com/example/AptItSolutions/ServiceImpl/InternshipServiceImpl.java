package com.example.AptItSolutions.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.InternshipForm;
import com.example.AptItSolutions.Repo.InternshipRepo;
import com.example.AptItSolutions.service.InternshipService;

@Service
public class InternshipServiceImpl implements InternshipService {

    @Autowired
    private InternshipRepo internshipRepo;

    @Override
    public InternshipForm save(InternshipForm internshipForm) {
        // TODO: Implement validation or other logic before saving
        generateCustomId(internshipForm);
        return internshipRepo.save(internshipForm);
    }

    @Override
    public List<InternshipForm> getAll() {
        return internshipRepo.findAll();
    }

    @Override
    public InternshipForm getById(String id) {
        // TODO: Implement logic to get by ID
        return null;
    }

    @Override
    public void deleteById(String id) {
        // TODO: Implement logic to delete by ID
    }

    private void generateCustomId(InternshipForm form) {
        try {
            List<InternshipForm> existingForms = internshipRepo.findAll();
            long maxSequenceNumber = 0;

            if (existingForms != null && !existingForms.isEmpty()) {
                for (InternshipForm existingForm : existingForms) {
                    String intRegId = existingForm.getIntRegId();
                    if (intRegId.matches("[A-Z]{3}\\d{7}")) {
                        // Extract the numeric part
                        long sequenceNumber = Long.parseLong(intRegId.substring(6));

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
            while (internshipRepo.existsByintRegId(customId)) {
                sequenceNumber++;
                customId = String.format("%s%s%03d", collegeCode, currentMonthYear, sequenceNumber);
            }

            form.setIntRegId(customId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}