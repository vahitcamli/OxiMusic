package com.turkcell.OXIMusic.business.rules;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.entities.User;

@Service
public class PaymentBusinessRules {
	
	public void checkIfAlreadySubscriber(User user) {
		
		boolean isAlreadySubscriber = user.getAuthorities().stream()
				.anyMatch(role -> role.getName().equalsIgnoreCase("subscriber"));

		if (isAlreadySubscriber) {
			throw new BusinessException(Messages.PaymentErrors.User_is_Already_Subscriber);
		}
	}

	public void checkIfAlreadyPartner(User user) {
		
		boolean isAlreadyPartner = user.getAuthorities().stream()
				.anyMatch(role -> role.getName().equalsIgnoreCase("partner"));

		if (isAlreadyPartner) {
			throw new BusinessException(Messages.PaymentErrors.User_is_Already_Partner);
		}
	}
	
}
