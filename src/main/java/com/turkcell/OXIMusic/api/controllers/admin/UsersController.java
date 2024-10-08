package com.turkcell.OXIMusic.api.controllers.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OXIMusic.business.abstracts.admin.UserService;
import com.turkcell.OXIMusic.dtos.requests.updates.UserUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.gets.UserGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.UserUpdateResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/users")
public class UsersController {

    private final UserService userService;
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public UserGetResponse getById (@PathVariable int id) {
		return userService.getById(id);
 	
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserUpdateResponse userUpdate (@Valid @RequestBody UserUpdateRequest userUpdateRequest,@PathVariable int id) {
    	
    	return userService.update(userUpdateRequest, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void delete(@PathVariable int id) {
    	userService.delete(id);
    }
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserGetResponse> getAll() {
		return userService.getAll();
	}
    
}