package com.turkcell.OXIMusic.dtos.requests.listen;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongListenRequest {
		@NotNull
	    private int songId; // Şarkının ID'si
}
