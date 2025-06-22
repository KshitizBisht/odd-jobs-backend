package com.oddJobs.controller;

import com.oddJobs.model.Person;
import com.oddJobs.model.dtos.PersonDto;
import com.oddJobs.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/person")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{username}")
    public PersonDto getPersonByUsername(@PathVariable String username) {
        log.info("This is the username {}", username);
        return Person.convertToPersonDto(personService.getPersonbyUsername(username));
    }

    @PostMapping("/")
    public PersonDto postPerson(@RequestBody PersonDto personDto) {
        return Person.convertToPersonDto(personService.insertPerson(personDto));
    }


}
