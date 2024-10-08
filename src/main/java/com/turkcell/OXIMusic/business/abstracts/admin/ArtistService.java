package com.turkcell.OXIMusic.business.abstracts.admin;

import java.util.List;

import com.turkcell.OXIMusic.dtos.requests.create.ArtistCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.ArtistUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.ArtistCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.ArtistGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.ArtistUpdateResponse;

public interface ArtistService {

	ArtistCreateResponse add(ArtistCreateRequest artist);

	void delete(int id);

	ArtistGetResponse getById(int id);

	ArtistUpdateResponse update(ArtistUpdateRequest artistUpdateRequest, int artistId);

	List<ArtistGetResponse> getAll();

}
