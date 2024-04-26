package com.learner.jobapplicationtracker.service;

import com.learner.jobapplicationtracker.entity.JobApplication;
import com.learner.jobapplicationtracker.repo.JobApplicationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepo repo;
    public List<JobApplication> getAllJobs(){
        return repo.findAll();
    }

    public JobApplication addJobApplication(JobApplication jobApplication) {
        return repo.save(jobApplication);
    }
}
