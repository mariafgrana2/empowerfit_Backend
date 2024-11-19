package com.empowerfit.app.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empowerfit.app.model.Address;
import com.empowerfit.app.service.AddressService;

@CrossOrigin(origins = "*")
@Controller
@ResponseBody
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping // http://localhost:8080/api/v1/addresses
    ResponseEntity<Address> createAddress(@RequestBody Address newAddress) {
        Address createdAddress = addressService.createAddress(newAddress);
        return ResponseEntity.status(201).body(createdAddress);
    }

    @GetMapping("{id}") // http://localhost:8080/api/v1/addresses/{id}
    Address getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }


    @PutMapping("{id}") // http://localhost:8080/api/v1/addresses/{id}
    ResponseEntity<Address> updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(address, id);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("{id}") // http://localhost:8080/api/v1/addresses/{id}
    ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Dirección con id " + id + " ha sido eliminada");
    }
}
