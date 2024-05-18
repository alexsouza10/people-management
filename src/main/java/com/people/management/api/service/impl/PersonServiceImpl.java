package com.people.management.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.management.api.model.Address;
import com.people.management.api.model.Person;
import com.people.management.api.repository.PersonRepository;
import com.people.management.api.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person editPerson(Long id, Person person) {
        Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            existingPerson.setFullName(person.getFullName());
            existingPerson.setDateOfBirth(person.getDateOfBirth());
            return personRepository.save(existingPerson);
        } else {
            return null;
        }
    }

    @Override
    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public List<Address> getAddressesByPersonId(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            return person.getAddresses();
        } else {
            return null;
        }
    }

    @Override
    public Address getPrimaryAddressByPersonId(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            return person.getPrimaryAddress();
        } else {
            return null;
        }
    }

    @Override
    public Person addAddress(Long id, Address address) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.getAddresses().add(address);
            return personRepository.save(person);
        } else {
            return null;
        }
    }

    @Override
    public Person editAddress(Long id, Long addressId, Address address) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            for (Address addr : person.getAddresses()) {
                if (addr.getId().equals(addressId)) {
                    addr.setStreet(address.getStreet());
                    addr.setZipCode(address.getZipCode());
                    addr.setNumber(address.getNumber());
                    addr.setCity(address.getCity());
                    addr.setState(address.getState());
                    return personRepository.save(person);
                }
            }
        }
        return null;
    }

    @Override
    public List<Address> listAddresses(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            return person.getAddresses();
        } else {
            return null;
        }
    }

    @Override
    public Person setPrimaryAddress(Long id, Long addressId) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            for (Address addr : person.getAddresses()) {
                if (addr.getId().equals(addressId)) {
                    person.setPrimaryAddress(addr);
                    return personRepository.save(person);
                }
            }
        }
        return null;
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person existingPerson = personRepository.findById(id).orElse(null);
        if (existingPerson != null) {
            existingPerson.setFullName(person.getFullName());
            existingPerson.setDateOfBirth(person.getDateOfBirth());
            return personRepository.save(existingPerson);
        } else {
            return null;
        }
    }

    @Override
    public boolean deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            return false;
        }
        personRepository.deleteById(id);
        return true;
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}