package com.example.demo.service.model;

import com.example.demo.model.Donor;
import com.example.demo.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentRequest {
  private Donor donor;
  private PaymentType paymentType;
  private String paymentId;
  private long amount;
}
