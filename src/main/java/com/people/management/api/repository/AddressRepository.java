package com.people.management.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people.management.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
