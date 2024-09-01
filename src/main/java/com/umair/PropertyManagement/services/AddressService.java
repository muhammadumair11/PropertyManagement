package com.umair.PropertyManagement.services;



import com.umair.PropertyManagement.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllAddresses();
    Address findAddressById(Long addressId);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    Boolean deleteAddress(Long addressId);
}

