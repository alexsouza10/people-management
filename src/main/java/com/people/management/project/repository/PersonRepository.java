package com.people.management.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.management.project.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
