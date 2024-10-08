package com.turkcell.OXIMusic.business.abstracts.admin;

import java.util.List;

import com.turkcell.OXIMusic.dtos.requests.updates.UserUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.gets.UserGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.UserUpdateResponse;

public interface UserService {

	void delete(int id);
	
	UserGetResponse getById(int id);
	
	UserUpdateResponse update(UserUpdateRequest userUpdateRequest, int userId);
	
	List<UserGetResponse> getAll();

}
