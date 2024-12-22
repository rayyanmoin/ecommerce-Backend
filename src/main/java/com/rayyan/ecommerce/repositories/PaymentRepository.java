package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment,Long> {
}
