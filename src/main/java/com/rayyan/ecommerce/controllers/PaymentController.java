package com.rayyan.ecommerce.controllers;

import com.rayyan.ecommerce.dto.OrderAddDto;
import com.rayyan.ecommerce.dto.OrderEditDto;
import com.rayyan.ecommerce.dto.PaymentAddDto;
import com.rayyan.ecommerce.dto.PaymentEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Order;
import com.rayyan.ecommerce.ecommerceObjects.OrderItem;
import com.rayyan.ecommerce.ecommerceObjects.Payment;
import com.rayyan.ecommerce.repositories.PaymentRepository;
import com.rayyan.ecommerce.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/list")
    public List<Payment> getlist(){
        return paymentService.getlist();
    }

    @PostMapping("/add")
    public String addPayment(@RequestBody PaymentAddDto paymentAddDto) {
        return paymentService.addPayment(paymentAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.findPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Payment> editPayment(@PathVariable("id") Long id, @RequestBody PaymentEditDto paymentEditDto){
        Payment updatedPayment = paymentService.editPayment(id, paymentEditDto);
        return ResponseEntity.ok(updatedPayment);
    }

}
