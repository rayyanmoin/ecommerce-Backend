package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
