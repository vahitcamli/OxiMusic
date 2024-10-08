package com.turkcell.OXIMusic.business.rules;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;

@Service
public class AuthBusinessRules {
	public void isAuthenticated(Authentication authentication){
        if(!authentication.isAuthenticated())
            throw new BusinessException(Messages.AuthErrors.Eposta_Veya_Sifre_Hatali);
    }
}
