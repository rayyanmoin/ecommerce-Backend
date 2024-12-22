package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address,Long> {
}
