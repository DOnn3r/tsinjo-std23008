package com.example.demo.repository;


import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);
}
