package com.oddJobs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oddJobs.model.Job;
import com.oddJobs.service.JobService;
import lombok.RequiredArgsConstructor;

@RestController("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
}
