package com.turkcell.OXIMusic.business.concretes.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.admin.UserService;
import com.turkcell.OXIMusic.business.rules.UserBusinessRules;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.OXIMusic.dataAccess.UserRepository;
import com.turkcell.OXIMusic.dtos.requests.updates.UserUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.gets.UserGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.UserUpdateResponse;
import com.turkcell.OXIMusic.entities.User;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	
	
	@Transactional
	@Override
	public void delete(int id) {
		userBusinessRules.UserShouldBeExist(id);
		
		User user =this.userRepository.findById(id).get();
		
		user.setDeleted(true);
		user.setDeletedDate(LocalDateTime.now());
		
		userRepository.save(user);
		
	}

	@Override
	public UserGetResponse getById(int id) {
		
		userBusinessRules.UserShouldBeExist(id);
		
		User user = userRepository.findById(id).get();
		
		UserGetResponse userGetResponse=modelMapperService.forResponse().map(user, UserGetResponse.class);
		
		return userGetResponse;
	}

	@Override
	public UserUpdateResponse update(UserUpdateRequest userUpdateRequest, int userId) {
		
		userBusinessRules.UserShouldBeExist(userId);
		
		User userUpdate = modelMapperService.forResponse().map(userUpdateRequest, User.class);
		
		userUpdate.setUpdatedDate(LocalDateTime.now());
		userUpdate.setId(userId);
		
		User updatedUser = userRepository.save(userUpdate);
		
		return modelMapperService.forResponse().map(updatedUser, UserUpdateResponse.class);
	}

	@Override
	public List<UserGetResponse> getAll() {
		
		userBusinessRules.UsersShouldBeExist();
		
		List<User> user = userRepository.findAll();
		
		return user.stream().map(
				userStream -> modelMapperService.forResponse().map(userStream, UserGetResponse.class)).toList();
	}

}
