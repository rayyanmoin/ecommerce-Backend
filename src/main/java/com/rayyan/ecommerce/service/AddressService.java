package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.AddressAddDto;
import com.rayyan.ecommerce.dto.AddressEditDto;
import com.rayyan.ecommerce.dto.ProductEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Product;
import com.rayyan.ecommerce.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.rayyan.ecommerce.ecommerceObjects.Address;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> getlist(){
        return addressRepository.findAll();
    }

    public String addAddress(AddressAddDto addressAddDto) {
        Address address = new Address();
        address.setUserId(addressAddDto.getUserId());
        address.setAddressLine1(addressAddDto.getAddressLine1());
        address.setAddressLine2(addressAddDto.getAddressLine2());
        address.setCity(addressAddDto.getCity());
        address.setState(addressAddDto.getState());
        address.setPostalCode(addressAddDto.getPostalCode());
        address.setCountry(addressAddDto.getCountry());
        address.setAddressType(addressAddDto.getAddressType());
        address.setCreatedAt(addressAddDto.getCreatedAt());
        address.setUpdatedAt(addressAddDto.getUpdatedAt());


        addressRepository.save(address);

        return "Address Added Successfully";
    }

    public Address findAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found"));
    }

    public Address editAddress(Long id, AddressEditDto addressEditDto) {
        // Find the existing product
        Address existingAddress = findAddressById(id);

        // Map fields from DTO to existing product entity
        existingAddress.setAddressLine1(addressEditDto.getAddressLine1());
        existingAddress.setAddressLine2(addressEditDto.getAddressLine2());
        existingAddress.setCity(addressEditDto.getCity());
        existingAddress.setState(addressEditDto.getState());
        existingAddress.setPostalCode(addressEditDto.getPostalCode());
        existingAddress.setCountry(addressEditDto.getCountry());
        existingAddress.setAddressType(addressEditDto.getAddressType());
        existingAddress.setCreatedAt(addressEditDto.getCreatedAt());
        existingAddress.setUpdatedAt(addressEditDto.getUpdatedAt());


        // Save and return the updated product
        return addressRepository.save(existingAddress);
    }


}
