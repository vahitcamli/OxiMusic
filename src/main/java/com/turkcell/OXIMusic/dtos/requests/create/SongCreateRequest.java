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
public class SongCreateRequest {
	@NotNull
	private String name;
	
	private String description;
	
	private int albumId;
	
	private int genreId;
	
	@NotNull
	private int artistId;
	
}
