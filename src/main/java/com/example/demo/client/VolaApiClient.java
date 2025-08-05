package com.example.demo.client;

import com.example.demo.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VolaApiClient {
    @Value("${vola.api.key}")
    private String apiKey;

    @Value("${vola.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public VolaApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PaymentStatus checkPaymentStatus(String paymentId) {
        // Implementation to call Vola API
        // This is a placeholder - you'll need to implement the actual API call
        return PaymentStatus.SUCCEEDED; // or FAILED based on API response
    }
}