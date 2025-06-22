package com.oddJobs.repository;

import com.oddJobs.model.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface PersonRepository extends MongoRepository<Person, ObjectId> {

    Optional<Person> findPersonByUsername(String username);

    Optional<Person> findPersonByFirstName(String name);
}
