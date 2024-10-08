package com.jobapi.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs") // Optional: sets a base URL for all methods in this controller
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created";
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return job;
    }

    @DeleteMapping("/{id}") // Corrected the path variable syntax
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
            Job job = jobService.deleteJobById(id);

            if (job != null) {
                return ResponseEntity.ok("Job deleted successfully"); // Return a success message with 200 status
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found"); // Return 404 if not found
            }
        }

}
