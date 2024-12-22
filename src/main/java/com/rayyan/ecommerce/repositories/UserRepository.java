package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
