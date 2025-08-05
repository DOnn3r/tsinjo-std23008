package com.example.demo.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {
  private String id;
  private Instant payementDate;
  private long amount;
  private Donor donor;
  private PaymentType paymentType;
  private PaymentStatus paymentStatus;
}
