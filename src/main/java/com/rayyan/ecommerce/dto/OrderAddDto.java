package com.rayyan.ecommerce.dto;

import com.rayyan.ecommerce.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddDto {

    private LocalDateTime orderDate;
    private OrderStatus status;
    private BigDecimal total;

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
