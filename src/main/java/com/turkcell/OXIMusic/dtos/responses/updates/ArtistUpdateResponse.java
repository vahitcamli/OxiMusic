package com.turkcell.OXIMusic.dtos.responses.updates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistUpdateResponse {

	private String name;
	
	private String surname;
}
