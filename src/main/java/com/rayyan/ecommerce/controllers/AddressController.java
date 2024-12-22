package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.AddressAddDto;
import com.rayyan.ecommerce.dto.AddressEditDto;
import com.rayyan.ecommerce.dto.ProductEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Address;
import com.rayyan.ecommerce.ecommerceObjects.Product;
import com.rayyan.ecommerce.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public List<Address> getlist(){
        return addressService.getlist();
    }

    @PostMapping("/add")
    public String addAddress(@RequestBody AddressAddDto addressAddDto){
        return addressService.addAddress(addressAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {
        // Call service to get the product or handle exception
        Address address = addressService.findAddressById(id);
        return ResponseEntity.ok(address);  // Return product with 200 OK
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable("id") Long id, @RequestBody AddressEditDto addressEditDto) {
        // Call service to update the product
        Address updatedAddress = addressService.editAddress(id, addressEditDto);
        return ResponseEntity.ok(updatedAddress);  // Return the updated product
    }


}
