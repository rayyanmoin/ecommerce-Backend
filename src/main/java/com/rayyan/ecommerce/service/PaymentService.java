package com.rayyan.ecommerce.service;

import com.rayyan.ecommerce.dto.OrderEditDto;
import com.rayyan.ecommerce.dto.PaymentAddDto;
import com.rayyan.ecommerce.dto.PaymentEditDto;
import com.rayyan.ecommerce.ecommerceObjects.Order;
import com.rayyan.ecommerce.ecommerceObjects.Payment;
import com.rayyan.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getlist(){
        return paymentRepository.findAll();
    }

    public String addPayment(PaymentAddDto paymentAddDto){
        Payment payment = new Payment();
        payment.setPaymentDate(paymentAddDto.getPaymentDate());
        payment.setAmount(paymentAddDto.getAmount());
        payment.setPaymentMethod(paymentAddDto.getPaymentMethod());
        payment.setStatus(paymentAddDto.getStatus());
        payment.setTransactionId(paymentAddDto.getTransactionId());
        payment.setOrderId(paymentAddDto.getOrderId());

        paymentRepository.save(payment);
        return "Payment added";

    }

    public Payment findPaymentById(Long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
    }

    public Payment editPayment(Long id, PaymentEditDto paymentEditDto) {

        Payment existingPayment = findPaymentById(id);
        existingPayment.setOrderId(paymentEditDto.getOrderId());
        existingPayment.setPaymentDate(paymentEditDto.getPaymentDate());
        existingPayment.setAmount(paymentEditDto.getAmount());
        existingPayment.setPaymentMethod(paymentEditDto.getPaymentMethod());
        existingPayment.setStatus(paymentEditDto.getStatus());
        existingPayment.setTransactionId(paymentEditDto.getTransactionId());

        return paymentRepository.save(existingPayment);
    }


}
