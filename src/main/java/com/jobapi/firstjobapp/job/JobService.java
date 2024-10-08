package com.jobapi.firstjobapp.job;

import java.util.List;

public interface JobService {
    // Find all jobs
    List<Job> findAll();

    // Create a new job, accepting a Job object as a parameter
    void createJob(Job job);

    Job getJobById(Long id);

    Job deleteJobById(Long id);
}

