package com.rayyan.ecommerce.ecommerceObjects;


import com.rayyan.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_orders"))
//    private Users user;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(nullable = false)
    private BigDecimal total;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_shipping_address"))
//    private Address shippingAddress;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "billing_address_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_billing_address"))
//    private Address billingAddress;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Users getUser() {
//        return user;
//    }
//
//    public void setUser(Users user) {
//        this.user = user;
//    }

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

//    public Address getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(Address shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    public Address getBillingAddress() {
//        return billingAddress;
//    }
//
//    public void setBillingAddress(Address billingAddress) {
//        this.billingAddress = billingAddress;
//    }
}
