package com.turkcell.OXIMusic.dtos.responses.listen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SongListenResponse {
	 private String name;
	    private String description;
	    private int stream;
	    private String albumName;
	    private String genreName;
	    private String artistName;
	    private String message; // Dinleme durumu ile ilgili mesaj
}
