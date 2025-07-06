package com.oddJobs.controller;

import com.oddJobs.model.Job;
import com.oddJobs.model.dtos.JobDto;
import com.oddJobs.service.JobService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/jobs")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = {"exp://192.168.1.115:8081", "http://localhost:8081"})
public class JobController {

    private final JobService jobService;

    @GetMapping("/job/{jobId}")
    public JobDto getJob(@PathVariable String jobId) {
        log.info("Request receive to get gig for gigId {}", jobId);
        return Job.convertToJobDto(jobService.getJobByJobId(jobId));
    }

    @PostMapping("/")
    public JobDto postJob(@RequestBody JobDto jobDto) {
        log.info("Insert new gig for gigId {}", jobDto.getJobId());
        return Job.convertToJobDto(jobService.insertJob(jobDto));
    }

    @GetMapping("/")
    public List<JobDto> getAllJobs() {
        log.info("Get all jobs");
        return jobService.findAllJobs();
    }

    @GetMapping("/{userId}")
    public List<JobDto> getPostedJobsForPerson(@PathVariable String userId) {
        log.info("Getting all jobs for userId{}", userId);
        return jobService.findAllPostedJobsForPerson(userId);
    }

}
