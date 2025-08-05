package com.example.demo.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
  private String id;
  private Instant paymentDate;
  private long amount;
  private Donor donor;
  private PaymentType paymentType;
  private PaymentStatus paymentStatus;
}
