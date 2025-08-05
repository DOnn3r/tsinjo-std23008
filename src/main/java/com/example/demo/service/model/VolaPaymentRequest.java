package com.example.demo.service.model;

import com.example.demo.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VolaPaymentRequest {
    private String donorEmail;
    private PaymentType paymentType;
    private String paymentId;
}
