package com.turkcell.OXIMusic.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

	private boolean paymentSuccess;
    private String message;
    
}
