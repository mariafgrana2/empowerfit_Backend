package com.empowerfit.app.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Address;
import com.empowerfit.app.repository.AddressRepository;
import com.empowerfit.app.service.AddressService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(Address address) {
        Set<ConstraintViolation<Address>> violations = validator.validate(address);
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation failed: ");
            for (ConstraintViolation<Address> violation : violations) {
                errorMessage.append(violation.getMessage()).append(" ");
            }
            throw new IllegalStateException(errorMessage.toString());
        }

        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("No existe una dirección con id " + id));
    }


    @Override
    public Address updateAddress(Address address, Long id) {
        Address existingAddress = getAddressById(id);
        existingAddress.setStreetAddress(address.getStreetAddress());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setPostalCode(address.getPostalCode());
        return addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        Address existingAddress = getAddressById(id);
        addressRepository.delete(existingAddress);
    }
}
