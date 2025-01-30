package com.example.AptItSolutions.ServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.ProjectRegistrationForm;
import com.example.AptItSolutions.Repo.ProjectRegistrationFormRepository;
import com.example.AptItSolutions.service.ProjectRegistrationFormService;

@Service
public class ProjectRegistrationFormServiceImpl implements ProjectRegistrationFormService {

    private final ProjectRegistrationFormRepository repository;

    @Autowired
    public ProjectRegistrationFormServiceImpl(ProjectRegistrationFormRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProjectRegistrationForm save(ProjectRegistrationForm form) {
        // Generate custom ID before saving
        generateCustomId(form);

        return repository.save(form);
    }



    @Override
    public List<ProjectRegistrationForm> getAll() {
        return repository.findAll();
    }

    @Override
    public ProjectRegistrationForm getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    
    
    
    

    private void generateCustomId(ProjectRegistrationForm form) {
        try {
            List<ProjectRegistrationForm> existingForms = repository.findAll();
            long maxSequenceNumber = 0;

            if (existingForms != null && !existingForms.isEmpty()) {
                for (ProjectRegistrationForm existingForm : existingForms) {
                    String proRegId = existingForm.getProRegId();
                    if (proRegId.matches("[A-Z]{3}\\d{7}")) {
                        // Find the last index of a digit in the custom ID
                        int lastDigitIndex = proRegId.lastIndexOf('0');
                        
                        // Extract the numeric part starting from the last digit index
                        String numericPart = proRegId.substring(lastDigitIndex);
                        
                        if (!numericPart.isEmpty()) {
                            long sequenceNumber = Long.parseLong(numericPart);
                            if (sequenceNumber > maxSequenceNumber) {
                                maxSequenceNumber = sequenceNumber;
                            }
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
            while (repository.existsByProRegId(customId)) {
                sequenceNumber++;
                customId = String.format("%s%s%03d", collegeCode, currentMonthYear, sequenceNumber);
            }

            form.setProRegId(customId);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}