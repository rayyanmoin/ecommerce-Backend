package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {
}
