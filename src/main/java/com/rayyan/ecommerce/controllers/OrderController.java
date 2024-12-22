package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.OrderAddDto;
import com.rayyan.ecommerce.dto.OrderEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Category;
import com.rayyan.ecommerce.ecommerceObjects.Order;
import com.rayyan.ecommerce.repositories.OrderRepository;
import com.rayyan.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public List<Order> getlist(){
        return orderService.getlist();
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody OrderAddDto orderAddDto){
        return orderService.addOrder(orderAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Order> editOrder(@PathVariable("id") Long id, @RequestBody OrderEditDto orderEditDto){
        Order updatedOrder = orderService.editOrder(id, orderEditDto);
        return ResponseEntity.ok(updatedOrder);
    }

}
