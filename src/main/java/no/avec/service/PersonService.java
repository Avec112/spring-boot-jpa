package no.avec.service;

import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by avec on 25/11/2016.
 */
//@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @PostConstruct
    private void fakeFillDb() {
        repository.save(new Person(0L, "Abraham", "Doe", 41, Person.Sex.MALE));
        repository.save(new Person(1L, "Bernhard", "Doe", 42, Person.Sex.MALE));
        repository.save(new Person(2L, "Cecil", "Doe", 43, Person.Sex.MALE));
        repository.save(new Person(3L, "Don", "Doe", 44, Person.Sex.MALE));
    }

    public Iterable<Person> findAllPersons() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findOne(id);
    }

}
