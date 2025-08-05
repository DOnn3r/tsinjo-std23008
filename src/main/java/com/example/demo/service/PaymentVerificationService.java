package com.example.demo.service;

import com.example.demo.client.VolaApiClient;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repository.PaymentRepository;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PaymentVerificationService {
  private final PaymentRepository paymentRepository;
  private final VolaApiClient volaApiClient;

  public PaymentVerificationService(
      PaymentRepository paymentRepository, VolaApiClient volaApiClient) {
    this.paymentRepository = paymentRepository;
    this.volaApiClient = volaApiClient;
  }

  @Scheduled(fixedRate = 60000) // Check every minute
  public void verifyPendingPayments() {
    List<Payment> pendingPayments = paymentRepository.findByPaymentStatus(PaymentStatus.VERIFYING);

    pendingPayments.forEach(
        payment -> {
          PaymentStatus newStatus = volaApiClient.checkPaymentStatus(payment.getId());
          if (newStatus != PaymentStatus.VERIFYING) {
            payment.setPaymentStatus(newStatus);
            paymentRepository.save(payment);
          }
        });
  }
}
