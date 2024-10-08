package com.turkcell.OXIMusic.business.abstracts.admin;

import java.util.List;

import com.turkcell.OXIMusic.dtos.requests.create.GenreCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.GenreUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.GenreCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.GenreGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.GenreUpdateResponse;

public interface GenreService {

	GenreCreateResponse add (GenreCreateRequest genre);
	
	void delete(int id);
	
	GenreGetResponse getById(int id);
	
	GenreUpdateResponse update(GenreUpdateRequest genreUpdateRequest, int genreId);
	
	List<GenreGetResponse> getAll();
	
}
