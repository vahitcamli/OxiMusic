package com.turkcell.OXIMusic.business.rules;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.dataAccess.UserRepository;
import com.turkcell.OXIMusic.entities.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserBusinessRules {

	private final UserRepository userRepository;
	
	public void UserShouldBeExist (int userId) {
		
		Optional<User> foundOptionalUser = userRepository.findById(userId);
		if(foundOptionalUser.isEmpty()) {
			throw new BusinessException(Messages.UserErrors.User_Not_Found);
		}
	}
	
	public void UsersShouldBeExist () {
		
		List<User> usersList = this.userRepository.findAll();
		if(usersList.isEmpty()) {
			throw new BusinessException(Messages.UserErrors.Users_Not_Found);
		}
	}
}
