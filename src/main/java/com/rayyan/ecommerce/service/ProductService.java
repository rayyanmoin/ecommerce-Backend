package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.ProductAddDto;
import com.rayyan.ecommerce.dto.ProductDTO;
import com.rayyan.ecommerce.dto.ProductEditDto;
import com.rayyan.ecommerce.dto.UsersDTO;
import com.rayyan.ecommerce.ecommerceObjects.Product;
import com.rayyan.ecommerce.ecommerceObjects.Users;
import com.rayyan.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public List<Product> getlist(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }


    public String addProduct(ProductAddDto productAddDto){
        Product product = new Product();
        product.setName(productAddDto.getName());
        product.setDescription(productAddDto.getDescription());
        product.setPrice(productAddDto.getPrice());
        product.setSku(productAddDto.getSku());
        product.setStock(productAddDto.getStock());
        product.setStatus(productAddDto.getStatus());
        product.setCreatedAt(productAddDto.getCreatedAt());
        product.setUpdatedAt(productAddDto.getUpdatedAt());

        productRepository.save(product);

        return "Product Added Successfully";
    }

    public Product editProduct(Long id, ProductEditDto productEditDto) {
        // Find the existing product
        Product existingProduct = findProductById(id);

        // Map fields from DTO to existing product entity
        existingProduct.setName(productEditDto.getName());
        existingProduct.setDescription(productEditDto.getDescription());
        existingProduct.setPrice(productEditDto.getPrice());
        existingProduct.setSku(productEditDto.getSku());
        existingProduct.setStock(productEditDto.getStock());
        existingProduct.setStatus(productEditDto.getStatus());

        // Save and return the updated product
        return productRepository.save(existingProduct);
    }


    public List<ProductDTO> getDroplist(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDropList = new ArrayList<>();
        for(Product product : products){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDropList.add(productDTO);
        }
        return productDropList;
    }


}
