package com.turkcell.OXIMusic.dtos.requests.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	 @NotNull
	    private String password;

	    @NotNull
	    @Email
	    private String email;
}
