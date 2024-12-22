package com.rayyan.ecommerce.controllers;


import com.rayyan.ecommerce.dto.ProductAddDto;
import com.rayyan.ecommerce.dto.ProductDTO;
import com.rayyan.ecommerce.dto.ProductEditDto;
import com.rayyan.ecommerce.dto.UsersDTO;
import com.rayyan.ecommerce.ecommerceObjects.Product;
import com.rayyan.ecommerce.ecommerceObjects.Users;
import com.rayyan.ecommerce.service.ProductService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> getlist(){
        return productService.getlist();
    }


    @GetMapping("/dropProduct")
    public List<ProductDTO> getDroplist(){
        return productService.getDroplist();
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductAddDto productAddDto){
        return productService.addProduct(productAddDto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody ProductEditDto productEditDto) {
        // Call service to update the product
        Product updatedProduct = productService.editProduct(id, productEditDto);
        return ResponseEntity.ok(updatedProduct);  // Return the updated product
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        // Call service to get the product or handle exception
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);  // Return product with 200 OK
    }


}

