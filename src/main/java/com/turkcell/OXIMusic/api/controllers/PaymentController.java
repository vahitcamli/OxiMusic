package com.turkcell.OXIMusic.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OXIMusic.business.abstracts.PaymentService;
import com.turkcell.OXIMusic.dtos.requests.payment.PaymentRequest;
import com.turkcell.OXIMusic.dtos.responses.payment.PaymentResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {
	private final PaymentService paymentService;

    @PostMapping("/subscribe")
    public ResponseEntity<PaymentResponse> processSubscriptionPayment(@Validated @RequestBody PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.SubscribeprocessPayment(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
}
}