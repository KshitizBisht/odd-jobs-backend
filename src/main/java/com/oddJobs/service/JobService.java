package com.oddJobs.service;

import com.mongodb.DuplicateKeyException;
import com.oddJobs.model.Job;
import com.oddJobs.model.dtos.JobDto;
import com.oddJobs.repository.JobRepository;
import com.oddJobs.repository.RetryableWriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobService {

    private static final String NOT_FOUND = "%s does not exists";
    private static final String DUPLICATE_KEY_EXCEPTION = "Duplicate key exception received";

    private final JobRepository jobRepository;
    private final RetryableWriteRepository<Job> gigRetryableWriteRepository;

    public Job getJobByJobId(String jobId) {
        Optional<Job> gig = jobRepository.findJobByJobId(jobId);
        if (gig.isEmpty()) {
            throw new NoSuchElementException(String.format(NOT_FOUND, "Job"));
        }
        return gig.get();
    }

    public Job insertJob(JobDto jobDto) {
        Job savedJob;
        try {
            savedJob = gigRetryableWriteRepository.insert(Job.convertFromJobDto(jobDto));
        } catch (DuplicateKeyException e) {
            throw new IllegalStateException(DUPLICATE_KEY_EXCEPTION);
        }
        return savedJob;
    }

    public List<JobDto> findAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(Job::convertToJobDto).collect(Collectors.toList());
    }

    public List<JobDto> findAllPostedJobsForPerson(String personId) {
        List<Job> jobs = jobRepository.findAllJobsWherePostedBy(personId);
        return jobs.isEmpty() ? Collections.emptyList() :
        jobs.stream().map(Job::convertToJobDto).collect(Collectors.toList());
    }

}
