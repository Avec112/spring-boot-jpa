package no.avec.controller;

import lombok.extern.slf4j.Slf4j;
import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by avec on 25/11/2016.
 */
@Controller
@Path("/person")
@Slf4j
public class PersonController {

    @Autowired
    //private PersonService service;
    private PersonRepository personRepository;



    @GET
    @Path("{id}")
    @Produces("application/json")
    public Person findPersonById(@PathParam("id") Long id) {
        log.debug("findPersonById({})", id);
        return personRepository.findOne(id);
        //return service.findById(id);
    }
    @GET
    @Path("/firstName/{firstName}")
    @Produces("application/json")
    public List<Person> findPersonByFirstName(@PathParam("firstName") String firstName) {
        log.debug("findPersonByFirstName({})", firstName);
        return personRepository.findByFirstName(firstName);
        //return service.findById(id);
    }

    @GET
    @Path("/lastName/{lastName}")
    @Produces("application/json")
    public List<Person> findPersonByLastName(@PathParam("lastName") String lastName) {
        log.debug("findPersonByLastName({})", lastName);
        return personRepository.findByLastName(lastName);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        log.debug("delete({})", id);
        return Response.accepted().build();
    }


    @GET
    @Produces("application/json")
    public Iterable<Person> findAll() {
        log.debug("findAll()");
        return personRepository.findAll();
        //return service.findAllPersons();
    }

    @PostConstruct
    private void fakeFillDb() {
        personRepository.save(new Person(0L, "Abraham", "Doe", 41, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Bernhard", "Doe", 42, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Cecil", "Doe", 43, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Don", "Doe", 44, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Abraham", "Moe", 45, Person.Sex.MALE));
    }
}
