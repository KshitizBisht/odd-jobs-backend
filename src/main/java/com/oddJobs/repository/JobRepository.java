package com.oddJobs.repository;

import com.oddJobs.model.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface JobRepository extends MongoRepository<Job, ObjectId> {

    Optional<Job> findJobByJobId(String jobId);

    @Query("{ 'posted_by': ?0 }")
    List<Job> findAllJobsWherePostedBy(String personId);
}
