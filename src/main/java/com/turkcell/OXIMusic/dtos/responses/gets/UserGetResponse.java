package com.turkcell.OXIMusic.dtos.responses.gets;

import java.time.LocalDateTime;

import com.turkcell.OXIMusic.entities.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserGetResponse {

	private int id;
	private String name;
	private String surName;	
	private LocalDateTime birthDate;	
	private String password;	
	private Gender gender;
	
}
