package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {
}
