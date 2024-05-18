package com.people.management.api.service;

import java.util.List;

import com.people.management.api.model.Address;

public interface AddressService {
    Address createAddress(Address address);

    List<Address> getAllAddresses();

    Address getAddress(Long id);

    boolean deleteAddress(Long id);

    Address getAddressById(Long id);

    Address updateAddress(Long id, Address address);
}
