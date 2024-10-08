package com.turkcell.OXIMusic.dtos.requests.updates;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistUpdateRequest {
	@NotNull
	private String name;
	
	private String surName;
	
}
