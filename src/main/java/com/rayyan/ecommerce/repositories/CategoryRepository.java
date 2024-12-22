package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
