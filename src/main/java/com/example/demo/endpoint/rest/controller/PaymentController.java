package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

  private final PaymentService paymentService;

  @GetMapping("/{id}")
  public ResponseEntity<Payment> getPayment(@PathVariable String id) {
    return ResponseEntity.ok(paymentService.getPaymentById(id));
  }

  @GetMapping("/{id}/status")
  public ResponseEntity<PaymentStatus> getPaymentStatus(@PathVariable String id) {
    return ResponseEntity.ok(paymentService.getPaymentStatus(id));
  }

  @PostMapping
  public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    return ResponseEntity.ok(paymentService.createPayment(payment));
  }
}