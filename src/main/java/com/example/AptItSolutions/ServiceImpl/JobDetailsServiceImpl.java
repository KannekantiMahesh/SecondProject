package com.example.AptItSolutions.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AptItSolutions.Entity.JobDetails;
import com.example.AptItSolutions.Entity.TrackerJobDetails;
import com.example.AptItSolutions.Repo.JobDetailsRepository;
import com.example.AptItSolutions.Repo.TrackerJobDetailsRepository;
import com.example.AptItSolutions.service.JobDetailsService;

@Service
public class JobDetailsServiceImpl implements JobDetailsService {
    

    @Autowired
    private  JobDetailsRepository jobDetailsRepository;
    

    @Autowired
    private TrackerJobDetailsRepository trackerJobDetailsRepository;

    @Override
    public JobDetails saveJobDetails(JobDetails jobDetails) {
        return jobDetailsRepository.save(jobDetails);
    }

    @Override
    public List<JobDetails> getAllJobDetails() {
        return jobDetailsRepository.findAll();
    }

    @Override
    public JobDetails getJobDetailsById(Long id) {
        Optional<JobDetails> optionalJobDetails = jobDetailsRepository.findById(id);
        return optionalJobDetails.orElse(null);
    }

    @Override
    public void deleteJobDetails(Long id) {
        jobDetailsRepository.deleteById(id);
    }

//	@Override
//	public JobDetails updateJobApplication(Long id, JobDetails updatedJobApplication) {
//		   TrackerJobDetails trackerJobDetails = new TrackerJobDetails();
//		JobDetails existing = jobDetailsRepository.findById(id)
//	               .orElseThrow(() -> new NoSuchElementException("ScrollNews not found with ID: " + id));

//		  Check for changes in each field and update the tracker
//        if (existing.getRole().equals(updatedJobApplication.getRole())) {
//          
//            trackerJobDetails.setExistingRole(existing.getRole());
//            trackerJobDetails.setNewRole(updatedJobApplication.getRole());
//        }
		
//        
//        if (!existing.getRole().equals(updatedJobApplication.getRole())) {
//            trackerJobDetails.setExistingRole(existing.getRole());
//            trackerJobDetails.setNewRole(updatedJobApplication.getRole());
//            trackerJobDetailsRepository.save(trackerJobDetails);
//        }
//        trackerJobDetailsRepository.save(trackerJobDetails);
        
//	       existing.setRole(updatedJobApplication.getRole());
//	       existing.setEducation(updatedJobApplication.getEducation());
//
//	       existing.setJobTitle(updatedJobApplication.getJobTitle());
//	       existing.setKeySkills(updatedJobApplication.getKeySkills());
//
//	       existing.setYearsOfExperience(updatedJobApplication.getYearsOfExperience());
//
//	       existing.setJobDescription(updatedJobApplication.getJobDescription());
//
//
//	       return jobDetailsRepository.save(existing);
//	}
//	
//}
    
    
    
    @Override
    public JobDetails updateJobApplication(Long jobId, JobDetails updatedJobDetails) {
        TrackerJobDetails trackerJobDetails = new TrackerJobDetails();
        Optional<JobDetails> existingJobDetailsOptional = jobDetailsRepository.findById(jobId);

        if (existingJobDetailsOptional.isPresent()) {
            JobDetails existingJobDetails = existingJobDetailsOptional.get();
            
//            if (!existingJobDetails.getRole().equals(updatedJobDetails.getRole())) {
//                trackerJobDetails.setJobId(existingJobDetails.getId());
//                trackerJobDetails.setExistingRole(existingJobDetails.getRole());
//                trackerJobDetails.setNewRole(updatedJobDetails.getRole());
//            }
            
            
            if (!areEqual(existingJobDetails.getRole(), updatedJobDetails.getRole())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingRole(existingJobDetails.getRole());
                trackerJobDetails.setNewRole(updatedJobDetails.getRole());
            }

            // Check for changes in each field and update the tracker
            if (!areEqual(existingJobDetails.getEducation(), updatedJobDetails.getEducation())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingEducation(existingJobDetails.getEducation());
                trackerJobDetails.setNewEducation(updatedJobDetails.getEducation());
            }

            if (!areEqual(existingJobDetails.getJobTitle(), updatedJobDetails.getJobTitle())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingJobTitle(existingJobDetails.getJobTitle());
                trackerJobDetails.setNewJobTitle(updatedJobDetails.getJobTitle());
            }

            if (!areEqual(existingJobDetails.getKeySkills(), updatedJobDetails.getKeySkills())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingKeySkills(existingJobDetails.getKeySkills());
                trackerJobDetails.setNewKeySkills(updatedJobDetails.getKeySkills());
            }

            if (!areEqual(existingJobDetails.getYearsOfExperience(), updatedJobDetails.getYearsOfExperience())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingYearsOfExperience(existingJobDetails.getYearsOfExperience());
                trackerJobDetails.setNewYearsOfExperience(updatedJobDetails.getYearsOfExperience());
            }

            if (!areEqual(existingJobDetails.getNumberOfPositions(), updatedJobDetails.getNumberOfPositions())) {
                trackerJobDetails.setJobId(existingJobDetails.getId());
                trackerJobDetails.setExistingNumberOfPositions(existingJobDetails.getNumberOfPositions());
                trackerJobDetails.setNewNumberOfPositions(updatedJobDetails.getNumberOfPositions());
            }
            
            trackerJobDetails.setUserName(updatedJobDetails.getUserName());

            trackerJobDetailsRepository.save(trackerJobDetails);

            // Update the existing entity
            existingJobDetails.setEducation(updatedJobDetails.getEducation());
            existingJobDetails.setJobTitle(updatedJobDetails.getJobTitle());
            existingJobDetails.setKeySkills(updatedJobDetails.getKeySkills());
            existingJobDetails.setYearsOfExperience(updatedJobDetails.getYearsOfExperience());
            existingJobDetails.setNumberOfPositions(updatedJobDetails.getNumberOfPositions());
            existingJobDetails.setJobDescription(updatedJobDetails.getJobDescription());
            existingJobDetails.setStatus(updatedJobDetails.getStatus());
            existingJobDetails.setCreationDate(updatedJobDetails.getCreationDate());

            return jobDetailsRepository.save(existingJobDetails);
        }

        return null;
    }

    // Utility method to compare two objects for equality, handling null values
    private <T> boolean areEqual(T obj1, T obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }
}
	
	

	
	
	
	