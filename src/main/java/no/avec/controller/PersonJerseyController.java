package no.avec.controller;

import lombok.extern.slf4j.Slf4j;
import no.avec.domain.Person;
import no.avec.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

/**
 * Created by avec on 25/11/2016.
 */
//@Controller
//@Path("/person")
@Slf4j
public class PersonJerseyController {

    @Autowired
    private PersonRepository personRepository;
/*
    public PersonController() {
        log.debug("PersonController constructor...");
    }

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("{id}")
    @Produces("application/person-1.0+json")
//    @Produces("application/json")
    public Person findPersonById(@PathParam("id") Long id) {
        log.debug("findPersonById({})", id);
        return personRepository.findOne(id);
        //return service.findById(id);
    }
    @GET
    @Path("/firstName/{firstName}")
    @Produces("application/person-1.0+json")
    public List<Person> findPersonByFirstName(@PathParam("firstName") String firstName) {
        log.debug("findPersonByFirstName({})", firstName);
        return personRepository.findByFirstName(firstName);
        //return service.findById(id);
    }

    @GET
    @Path("/lastName/{lastName}")
    @Produces("application/person-1.0+json")
    public List<Person> findPersonByLastName(@PathParam("lastName") String lastName) {
        log.debug("findPersonByLastName({})", lastName);
        return personRepository.findByLastName(lastName);
    }

    // curl -i -H "Accept: application/json" http://localhost:8080/person/5 -X DELETE
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        log.debug("delete({})", id);
        personRepository.delete(id);
        return Response.accepted().build();
    }

    //  // v2.0 example and same url as v1.0.
    // curl -i -H "Content-Type: application/person-1.0+json" -X POST -d '{"firstName":"Solfrid","lastName":"Volden", "age":31,"sex":"FEMALE"}' http://localhost:8080/person
    @POST
    @Produces("application/person-1.0+json")
    public Response save(Person person) {
        log.debug("save -> {}", person);
        personRepository.save(person);
        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", person.getId())
                .build();
        log.debug("URI location: {}", location);
        return Response.created(location).build();
    }
*/
    // v1.0 example and same url as v2.0.
    // curl -i -H "Accept: application/person-1.0+json" http://localhost:8080/person
    @GET
//    @Produces("application/person-1.0+json")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> findAll() {
        log.debug("findAll() v1.0");

//        return Arrays.asList(new Person(0L, "firstname", "lastname", 66, Person.Sex.FEMALE));
//        return Arrays.asList(new Person( "firstname", "lastname", 66, Person.Sex.FEMALE));
        return personRepository.findAll();
    }
/*    // v2.0 example and same url as v1.0.
    // curl -i -H "Accept: application/person-2.0+json" http://localhost:8080/person
//    @GET
//    @Produces("application/person-2.0+json")
    public Iterable<Person> findAllv2() {
        log.debug("findAll() v2.0");
        return personRepository.findAll();
    }

    @PostConstruct
    private void fakeFillDb() {
        personRepository.save(new Person(0L, "Abraham", "Doe", 41, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Bernhard", "Doe", 42, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Cecil", "Doe", 43, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Don", "Doe", 44, Person.Sex.MALE));
        personRepository.save(new Person(0L, "Abraham", "Moe", 45, Person.Sex.MALE));
    }*/
}
