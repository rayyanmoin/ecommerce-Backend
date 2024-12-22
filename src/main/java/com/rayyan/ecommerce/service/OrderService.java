package com.rayyan.ecommerce.service;


import com.rayyan.ecommerce.dto.OrderAddDto;
import com.rayyan.ecommerce.dto.OrderEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Order;
import com.rayyan.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getlist(){
        return orderRepository.findAll();
    }

    public String addOrder(OrderAddDto orderAddDto){
        Order order = new Order();
        order.setOrderDate(orderAddDto.getOrderDate());
        order.setStatus(orderAddDto.getStatus());
        order.setTotal(orderAddDto.getTotal());

        orderRepository.save(order);

        return "Order Added Successfully";
    }

    public Order findOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public Order editOrder(Long id, OrderEditDto orderEditDto) {

        Order existingOrder = findOrderById(id);
        existingOrder.setOrderDate(orderEditDto.getOrderDate());
        existingOrder.setStatus(orderEditDto.getStatus());
        existingOrder.setTotal(orderEditDto.getTotal());

        return orderRepository.save(existingOrder);
    }

}
