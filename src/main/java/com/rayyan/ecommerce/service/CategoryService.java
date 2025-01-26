package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.CategoryAddDto;
import com.rayyan.ecommerce.dto.CategoryEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Category;
import com.rayyan.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getlist(){
        return categoryRepository.findAll();
    }

    public String addCategory(CategoryAddDto categoryAddDto){
        Category category = new Category();
        category.setName(categoryAddDto.getName());
        category.setDescription(categoryAddDto.getDescription());
        category.setCreatedAt(categoryAddDto.getCreatedAt());
        category.setUpdatedAt(categoryAddDto.getUpdatedAt());

        categoryRepository.save(category);

        return "Category Added Successfully";
    }

    public Category findCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
    }


    public Category editCategory(Long id, CategoryEditDto categoryEditDto) {

        Category existingCategory = findCategoryById(id);
        existingCategory.setName(categoryEditDto.getName());
        existingCategory.setDescription(categoryEditDto.getDescription());
        existingCategory.setCreatedAt(categoryEditDto.getCreatedAt());
        existingCategory.setUpdatedAt(categoryEditDto.getUpdatedAt());

        return categoryRepository.save(existingCategory);
    }


}
