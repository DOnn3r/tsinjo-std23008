package com.example.demo.repository;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
  List<Payment> findByPaymentStatus(PaymentStatus paymentStatus);
}
