package com.oddJobs.service;

import com.oddJobs.model.Job;
import com.oddJobs.repository.JobRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAllJobs();
    }
}
