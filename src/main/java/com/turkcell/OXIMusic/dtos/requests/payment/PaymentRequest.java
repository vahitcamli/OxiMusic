package com.turkcell.OXIMusic.dtos.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String creditCardNumber;

    private String cardHolderName;

    private String expiryDate;

    private String cvv;
}
