package com.empowerfit.app.service;

import java.util.Set;
import com.empowerfit.app.model.Address;

public interface AddressService {

	Address createAddress(Address address);
	Address getAddressById(Long id);
	Set<Address> getAllAddressesByCountry(String country);
	Address updateAddress(Address address, Long id);
	void deleteAddress(Long id);

}
