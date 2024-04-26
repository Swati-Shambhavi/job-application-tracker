package com.learner.jobapplicationtracker.controller;

import com.learner.jobapplicationtracker.entity.JobApplication;
import com.learner.jobapplicationtracker.service.JobApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-application")
@AllArgsConstructor
public class JobApplicationController {
    private final JobApplicationService service;
    @GetMapping
    public List<JobApplication> getAllJobs(){
        return service.getAllJobs();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addJobApplication(@RequestBody JobApplication jobApplication) {
        try {
            JobApplication savedJobApplication = service.addJobApplication(jobApplication);
            return new ResponseEntity<>("Job application added successfully with ID: " + savedJobApplication.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add job application: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
