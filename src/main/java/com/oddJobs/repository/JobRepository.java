package com.oddJobs.repository;

import com.oddJobs.model.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface JobRepository extends MongoRepository<Job, ObjectId> {

    public List<Job> findAllJobs();

}
