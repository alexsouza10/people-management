package com.people.management.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.people.management.project.model.Address;
import com.people.management.project.repository.AddressRepository;
import com.people.management.project.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            return false;
        }
        addressRepository.deleteById(id);
        return true;
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setStreet(address.getStreet());
            existingAddress.setZipCode(address.getZipCode());
            existingAddress.setNumber(address.getNumber());
            existingAddress.setCity(address.getCity());
            existingAddress.setState(address.getState());
            return addressRepository.save(existingAddress);
        } else {
            return null;
        }
    }
}
