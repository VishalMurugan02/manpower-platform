package com.manpower.platform.repository;

import com.manpower.platform.entity.JobPosting

;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {


}