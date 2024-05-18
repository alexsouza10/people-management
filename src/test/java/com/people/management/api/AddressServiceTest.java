package com.people.management.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.people.management.api.model.Address;
import com.people.management.api.repository.AddressRepository;
import com.people.management.api.service.impl.AddressServiceImpl;

@SpringBootTest
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Test
    void testCreateAddress_Success() {
        Address address = new Address("123 Main St", "12345", 5, "City", "State");
        when(addressRepository.save(address)).thenReturn(address);
        Address createdAddress = addressService.createAddress(address);
        assertNotNull(createdAddress);
        assertEquals(address.getStreet(), createdAddress.getStreet());
    }

    @Test
    void testUpdateAddress_Success() {
        Long addressId = 1L;
        Address existingAddress = new Address(addressId, "123 Main St", "12345", 1, "City", "State");
        Address updatedAddress = new Address(addressId, "456 Elm St", "67890", 2, "New City", "New State");

        when(addressRepository.findById(addressId)).thenReturn(Optional.of(existingAddress));
        when(addressRepository.save(existingAddress)).thenReturn(updatedAddress);

        Address result = addressService.updateAddress(addressId, updatedAddress);
        assertNotNull(result);
        assertEquals(updatedAddress.getStreet(), result.getStreet());
    }

    @Test
    void testGetAddressById_Success() {
        Long addressId = 1L;
        Address address = new Address(addressId, "123 Main St", "12345", 1, "City", "State");

        when(addressRepository.findById(addressId)).thenReturn(Optional.of(address));

        Address result = addressService.getAddressById(addressId);
        assertNotNull(result);
        assertEquals(address.getStreet(), result.getStreet());
    }

    @Test
    void testGetAllAddresses_Success() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(1L, "123 Main St", "12345", 1, "City", "State"));
        addresses.add(new Address(2L, "456 Elm St", "67890", 2, "New City", "New State"));

        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> result = addressService.getAllAddresses();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteAddress_Success() {
        Long addressId = 1L;
        when(addressRepository.existsById(addressId)).thenReturn(true);

        boolean result = addressService.deleteAddress(addressId);
        assertEquals(true, result);
        verify(addressRepository, times(1)).deleteById(addressId);
    }

    @Test
    void testDeleteAddress_NotFound() {
        Long addressId = 1L;
        when(addressRepository.existsById(addressId)).thenReturn(false);

        boolean result = addressService.deleteAddress(addressId);
        assertEquals(false, result);
    }
}
