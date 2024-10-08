package com.turkcell.OXIMusic.dtos.responses.gets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongGetResponse {

	private String name;
	private String description;
	
}
