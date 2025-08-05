package com.example.demo.service;

import com.example.demo.client.VolaApiClient;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repository.PaymentRepository;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaymentService {

  private final PaymentRepository paymentRepository;
  private final VolaApiClient volaApiClient;

  @Transactional
  public Payment createPayment(Payment payment) {
    payment.setPaymentDate(Instant.now());
    payment.setPaymentStatus(PaymentStatus.VERIFYING);
    return paymentRepository.save(payment);
  }

  public Payment getPaymentById(String id) {
    return paymentRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
  }

  @Async
  public CompletableFuture<PaymentStatus> verifyPaymentAsync(String paymentId) {
    PaymentStatus newStatus = volaApiClient.checkPaymentStatus(paymentId);
    updatePaymentStatus(paymentId, newStatus);
    return CompletableFuture.completedFuture(newStatus);
  }

  @Transactional
  public Payment updatePaymentStatus(String paymentId, PaymentStatus status) {
    Payment payment = getPaymentById(paymentId);
    payment.setPaymentStatus(status);
    return paymentRepository.save(payment);
  }

  public PaymentStatus getPaymentStatus(String paymentId) {
    return getPaymentById(paymentId).getPaymentStatus();
  }
}
