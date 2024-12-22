package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.ecommerceObjects.Order;
import com.rayyan.ecommerce.ecommerceObjects.OrderItem;
import com.rayyan.ecommerce.repositories.OrderItemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderItem")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;

    public OrderItemController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping("/list")
    public List<OrderItem> getlist(){
        return orderItemRepository.findAll();
    }


}
