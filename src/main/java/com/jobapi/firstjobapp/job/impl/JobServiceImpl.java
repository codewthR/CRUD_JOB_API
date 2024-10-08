package com.jobapi.firstjobapp.job.impl;

import com.jobapi.firstjobapp.job.Job;
import com.jobapi.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    // Use LinkedList for more efficient insertions and initial job creation
    private final List<Job> jobs = new LinkedList<>(); // Use LinkedList for efficient insertions
    private Long nextId = 1L; // ID counter initialized to 1

    @Override
    public List<Job> findAll() {
        // Return an unmodifiable list to prevent external modification
        return Collections.unmodifiableList(jobs);
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++); // Set the next available ID and increment the counter
        jobs.add(job); // Add the job to the list
    }
    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public Job deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return job;
            }
        }
        return null;
    }

}
