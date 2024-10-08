package com.turkcell.OXIMusic.business.abstracts;

import com.turkcell.OXIMusic.dtos.requests.payment.PaymentRequest;
import com.turkcell.OXIMusic.dtos.responses.payment.PaymentResponse;

public interface PaymentService {
	 PaymentResponse SubscribeprocessPayment(PaymentRequest paymentRequest);
	 
	 PaymentResponse PartnerprocessPayment(PaymentRequest paymentRequest);
}
