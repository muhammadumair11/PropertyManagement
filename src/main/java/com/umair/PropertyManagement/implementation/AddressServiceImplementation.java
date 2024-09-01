package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Address;
import com.umair.PropertyManagement.repository.AddressRepository;
import com.umair.PropertyManagement.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Address address1 = findAddressById(address.getId());

        if(address != null) {
            address.setId(address1.getId());
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public Boolean deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);

        if(findAddressById(addressId) == null)
            return true;
        return false;
    }
}
