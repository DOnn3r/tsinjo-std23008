package com.example.demo.service.model;

import com.example.demo.model.Application;
import com.example.demo.model.Donor;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolaPaymentResponse {
  private String id;
  private Payment pspPayment;
  private Instant creationInstant;
  private Instant lastPspVerificationInstant;
  private int verificationAttemptNb;
  private Donor payer;
  private Application application;
  private PaymentStatus verificationStatus;
}
