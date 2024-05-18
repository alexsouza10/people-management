package com.people.management.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.people.management.project.model.Address;
import com.people.management.project.model.Person;
import com.people.management.project.repository.PersonRepository;
import com.people.management.project.service.impl.PersonServiceImpl;

@SpringBootTest
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void testCreatePerson_Sucess() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("10001");

        Person person = new Person(null, "John Doe", new Date(), null, address);

        when(personRepository.save(person)).thenReturn(person);

        Person createdPerson = personService.createPerson(person);

        assertNotNull(createdPerson);

        assertEquals(person.getFullName(), createdPerson.getFullName());
    }

    @Test
    void testUpdatePerson_Sucess() {
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("10001");

        Person person = new Person(1L, "John Doe", new Date(), null, address);

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        when(personRepository.save(person)).thenReturn(person);

        Person updatPerson = personService.updatePerson(1L, person);

        assertNotNull(updatPerson);

        assertEquals(person.getFullName(), updatPerson.getFullName());
    }

    @Test
    void testGetPersonById_Success() {
        Long personId = 1L;
        Person person = new Person(personId, "John Doe", new Date(), new ArrayList<>(), null);

        when(personRepository.findById(personId)).thenReturn(java.util.Optional.of(person));

        Person result = personService.getPersonById(personId);
        assertNotNull(result);
        assertEquals(person.getFullName(), result.getFullName());
    }

    @Test
    void testGetAllPeople_Success() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1L, "John Doe", new Date(), new ArrayList<>(), null));
        people.add(new Person(2L, "Jane Doe", new Date(), new ArrayList<>(), null));

        when(personRepository.findAll()).thenReturn(people);

        List<Person> result = personService.getAllPeople();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testDeletePerson_Success() {
        Long personId = 1L;
        when(personRepository.existsById(personId)).thenReturn(true);

        boolean result = personService.deletePerson(personId);
        assertEquals(true, result);
    }
}
