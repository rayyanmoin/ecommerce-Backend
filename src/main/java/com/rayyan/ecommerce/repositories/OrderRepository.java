package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order,Long> {
}
