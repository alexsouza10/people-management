package com.people.management.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people.management.project.model.Address;
import com.people.management.project.model.Person;
import com.people.management.project.service.PersonService;

@RestController
@RequestMapping("api/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.getAllPeople();
        return ResponseEntity.ok(people);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<List<Address>> getAddressesByPersonId(@PathVariable Long id) {
        List<Address> addresses = personService.getAddressesByPersonId(id);
        if (addresses != null) {
            return ResponseEntity.ok(addresses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/primary-address")
    public ResponseEntity<Address> getPrimaryAddressByPersonId(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        if (person != null && person.getPrimaryAddress() != null) {
            return ResponseEntity.ok(person.getPrimaryAddress());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatePerson) {
        Person person = personService.updatePerson(id, updatePerson);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
