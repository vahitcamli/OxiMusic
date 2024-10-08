package com.turkcell.OXIMusic.business.abstracts.admin;

import java.util.List;

import com.turkcell.OXIMusic.dtos.requests.create.AlbumCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.AlbumUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.AlbumCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.AlbumGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.AlbumUpdateResponse;

public interface AlbumService {

	AlbumCreateResponse add (AlbumCreateRequest album);
	
	void delete(int id);
	
	AlbumUpdateResponse update(AlbumUpdateRequest albumUpdateRequest, int albumId);
	
	AlbumGetResponse getById(int id);
	
	List<AlbumGetResponse> getAll();
	
}
