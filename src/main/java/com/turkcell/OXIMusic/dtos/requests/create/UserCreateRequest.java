package com.turkcell.OXIMusic.dtos.requests.create;

import java.time.LocalDateTime;

import com.turkcell.OXIMusic.entities.enums.Gender;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateRequest {
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String surName;
	
	@NotNull
	private LocalDateTime birthDate;
	
	@NotNull
	private String password;
	
	@NotNull
	private Gender gender;
	
}
