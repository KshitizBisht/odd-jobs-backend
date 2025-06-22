package com.oddJobs.service;

import com.oddJobs.model.Person;
import com.oddJobs.model.dtos.PersonDto;
import com.oddJobs.repository.PersonRepository;
import com.oddJobs.repository.RetryableWriteRepository;
import com.mongodb.DuplicateKeyException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private static final String NOT_FOUND = "%s does not exists";
    private static final String DUPLICATE_KEY_EXCEPTION = "Duplicate key exception received";

    private final PersonRepository personRepository;
    private final RetryableWriteRepository<Person> personRetryableWriteRepository;

    public Person getPersonByFirstName(String name) {
        Optional<Person> person = personRepository.findPersonByFirstName("Arlo");
        if (person.isEmpty()) {
            throw new NoSuchElementException(String.format(NOT_FOUND, "Person"));
        }
        return person.get();
    }

    public Person getPersonbyUsername(String id) {
        Optional<Person> person = personRepository.findPersonByUsername(id);
        if (person.isEmpty()) {
            throw new NoSuchElementException(String.format(NOT_FOUND, "Person"));
        }
        return person.get();
    }


    public Person insertPerson(PersonDto personDto) {
        Person savedPerson;
        try{
            savedPerson = personRetryableWriteRepository.insert(Person.convertFromPersonDto(personDto));
        } catch (DuplicateKeyException e) {
            throw new IllegalStateException(DUPLICATE_KEY_EXCEPTION);
        }
        return savedPerson;
    }
}
