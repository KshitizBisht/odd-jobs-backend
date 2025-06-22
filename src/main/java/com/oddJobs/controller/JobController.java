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
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    private final JobService jobService;

    @GetMapping("/{gigId}")
    public JobDto getGig(@PathVariable String gigId) {
        log.info("Request receive to get gig for gigId {}", gigId);
        return Job.convertToGigDto(jobService.getGigByGigId(gigId));
    }

    @PostMapping("/")
    public JobDto postGig(@RequestBody JobDto jobDto) {
        log.info("Insert new gig for gigId {}", jobDto.getGigId());
        return Job.convertToGigDto(jobService.insertGig(jobDto));
    }

    @GetMapping("/")
    public List<JobDto> getAllGigs() {
        log.info("Get all gigs");
        return jobService.findAllGigs();
    }


}
