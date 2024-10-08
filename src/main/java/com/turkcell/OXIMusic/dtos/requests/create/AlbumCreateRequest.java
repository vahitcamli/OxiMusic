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
public class AlbumCreateRequest {
	
	@NotNull
	private String name;
	
	private String desc;
	
}
