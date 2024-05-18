package com.people.management.project.service;

import java.util.List;

import com.people.management.project.model.Address;
import com.people.management.project.model.Person;

public interface PersonService {
    Person createPerson(Person person);

    Person editPerson(Long id, Person person);

    List<Person> listPersons();

    Person getPerson(Long id);

    Person getPersonById(Long id);

    List<Person> getAllPeople();

    Person addAddress(Long id, Address address);

    Person editAddress(Long id, Long addressId, Address address);

    List<Address> listAddresses(Long id);

    Person setPrimaryAddress(Long id, Long addressId);

    Person updatePerson(Long id, Person person);

    boolean deletePerson(Long id);

    List<Address> getAddressesByPersonId(Long id);

    Address getPrimaryAddressByPersonId(Long id);
}