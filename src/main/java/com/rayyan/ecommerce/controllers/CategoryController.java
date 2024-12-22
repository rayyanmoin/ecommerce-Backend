package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.CategoryAddDto;
import com.rayyan.ecommerce.dto.CategoryEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Address;
import com.rayyan.ecommerce.ecommerceObjects.Category;
import com.rayyan.ecommerce.repositories.CategoryRepository;
import com.rayyan.ecommerce.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public List<Category> getlist(){
        return categoryService.getlist();
    }

    @PostMapping("/add")
    public String addCategory(@RequestBody CategoryAddDto categoryAddDto){
        return categoryService.addCategory(categoryAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable("id") Long id, @RequestBody CategoryEditDto categoryEditDto){
        Category updatedCategory = categoryService.editCategory(id, categoryEditDto);
        return ResponseEntity.ok(updatedCategory);
    }



}
