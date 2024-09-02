package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Address;
import com.umair.PropertyManagement.model.dto.AddressDTO;

public class AddressMapper {
    public static AddressDTO AddressToAddressDTO(Address address) {
        if (address == null) return null;

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setZipCode(address.getZipCode());

        return addressDTO;
    }

    public static Address AddressDTOToAddress(AddressDTO addressDTO) {
        if (addressDTO == null) return null;

        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setZipCode(addressDTO.getZipCode());

        return address;
    }
}
