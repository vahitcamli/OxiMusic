package com.turkcell.OXIMusic.dtos.responses.creates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateResponse {

	private String name;
	
	private String surname;
}
