package com.rayyan.ecommerce.repositories;

import com.rayyan.ecommerce.ecommerceObjects.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Long> {
}
