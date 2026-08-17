package com.manpower.platform.controller;

import com.manpower.platform.dto.CreateJobRequest;
import com.manpower.platform.dto.JobPostingResponse;
import com.manpower.platform.service.JobPostingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobPostingController {

    private final JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping
    public ResponseEntity<JobPostingResponse> createJob(
            @Valid @RequestBody CreateJobRequest request) {

        JobPostingResponse response =
                jobPostingService.createJob(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}