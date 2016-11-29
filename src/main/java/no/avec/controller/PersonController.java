package no.avec.controller;

import lombok.extern.slf4j.Slf4j;
import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by avec on 25/11/2016.
 */
@RestController
@RequestMapping(value="/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(headers="Accept=application/person-1.0+json")
    public Iterable<Person> findPerson() {
        log.debug("findPerson() v1.0");
        return personRepository.findAll();
    }

    @RequestMapping(headers="Accept=application/person-2.0+json")
    public Iterable<Person> findPerson_2_0() {
        log.debug("findPerson() v2.0");
        return personRepository.findAll();
    }

    @PostConstruct
    private void fakeFillDb() {
        personRepository.save(new Person("Abraham", "Doe", 41, Person.Sex.MALE));
        personRepository.save(new Person("Bernhard", "Doe", 42, Person.Sex.MALE));
        personRepository.save(new Person("Cecil", "Doe", 43, Person.Sex.MALE));
        personRepository.save(new Person("Don", "Doe", 44, Person.Sex.MALE));
    }
}
