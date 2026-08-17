package com.manpower.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class JobPostingResponse {

    private Long id;
    private Long employerId;
    private String title;
    private String description;
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer workersRequired;
    private BigDecimal offeredAmount;
    private String location;
    private String status;

    public JobPostingResponse(
            Long id,
            Long employerId,
            String title,
            String description,
            LocalDate workDate,
            LocalTime startTime,
            LocalTime endTime,
            Integer workersRequired,
            BigDecimal offeredAmount,
            String location,
            String status) {

        this.id = id;
        this.employerId = employerId;
        this.title = title;
        this.description = description;
        this.workDate = workDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workersRequired = workersRequired;
        this.offeredAmount = offeredAmount;
        this.location = location;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Integer getWorkersRequired() {
        return workersRequired;
    }

    public BigDecimal getOfferedAmount() {
        return offeredAmount;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}