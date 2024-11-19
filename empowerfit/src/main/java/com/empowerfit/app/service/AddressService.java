package com.empowerfit.app.service;


import com.empowerfit.app.model.Address;

public interface AddressService {

	Address createAddress(Address address);
	Address getAddressById(Long id);
	Address updateAddress(Address address, Long id);
	void deleteAddress(Long id);

}
