package com.people.management.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.management.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
