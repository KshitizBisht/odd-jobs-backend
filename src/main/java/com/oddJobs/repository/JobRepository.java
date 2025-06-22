package com.oddJobs.repository;

import com.oddJobs.model.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface JobRepository extends MongoRepository<Job, ObjectId> {

    public Optional<Job> findJobByJobId(String jobId);
}
