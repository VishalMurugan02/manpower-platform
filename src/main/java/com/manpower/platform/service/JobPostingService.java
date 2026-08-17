package com.manpower.platform.service;

import com.manpower.platform.dto.CreateJobRequest;
import com.manpower.platform.entity.EmployerProfile;
import com.manpower.platform.entity.JobPosting;
import com.manpower.platform.repository.EmployerProfileRepository;
import com.manpower.platform.repository.JobPostingRepository;
import org.springframework.stereotype.Service;
import com.manpower.platform.dto.JobPostingResponse;

import java.time.LocalDateTime;

@Service
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final EmployerProfileRepository employerProfileRepository;

    public JobPostingService(
            JobPostingRepository jobPostingRepository,
            EmployerProfileRepository employerProfileRepository) {

        this.jobPostingRepository = jobPostingRepository;
        this.employerProfileRepository = employerProfileRepository;
    }

    public JobPostingResponse createJob(CreateJobRequest request, Long userId) {

    EmployerProfile employerProfile =
            employerProfileRepository.findByUserId(userId)
                    .orElseThrow(() ->
                            new RuntimeException("Employer profile not found")
                    );

    JobPosting jobPosting = new JobPosting();

    jobPosting.setEmployerProfile(employerProfile);
    jobPosting.setTitle(request.getTitle());
    jobPosting.setDescription(request.getDescription());
    jobPosting.setWorkDate(request.getWorkDate());
    jobPosting.setStartTime(request.getStartTime());
    jobPosting.setEndTime(request.getEndTime());
    jobPosting.setWorkersRequired(request.getWorkersRequired());
    jobPosting.setOfferedAmount(request.getOfferedAmount());
    jobPosting.setLocation(request.getLocation());

    jobPosting.setStatus("OPEN");

    jobPosting.setCreatedAt(LocalDateTime.now());
    jobPosting.setUpdatedAt(LocalDateTime.now());

    JobPosting savedJob = jobPostingRepository.save(jobPosting);

    return new JobPostingResponse(
            savedJob.getId(),
            savedJob.getEmployerProfile().getId(),
            savedJob.getTitle(),
            savedJob.getDescription(),
            savedJob.getWorkDate(),
            savedJob.getStartTime(),
            savedJob.getEndTime(),
            savedJob.getWorkersRequired(),
            savedJob.getOfferedAmount(),
            savedJob.getLocation(),
            savedJob.getStatus()
    );
}
}