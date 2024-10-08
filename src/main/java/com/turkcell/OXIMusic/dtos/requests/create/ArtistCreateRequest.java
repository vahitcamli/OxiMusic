package com.turkcell.OXIMusic.dtos.requests.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistCreateRequest {
	@NotNull
	private String name;
	
	private String surName;
	
}
