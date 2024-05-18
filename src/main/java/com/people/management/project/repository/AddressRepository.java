package com.people.management.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.management.project.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
