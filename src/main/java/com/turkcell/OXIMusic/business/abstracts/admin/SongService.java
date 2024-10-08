package com.turkcell.OXIMusic.business.abstracts.admin;

import java.util.List;

import com.turkcell.OXIMusic.dtos.requests.create.SongCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.listen.SongListenRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.SongUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.SongCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.SongGetResponse;
import com.turkcell.OXIMusic.dtos.responses.listen.SongListenResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.SongUpdateResponse;

public interface SongService {

	SongCreateResponse add (SongCreateRequest song);
	
	void delete(int id);
	
	SongGetResponse getById(int id);
	
	SongUpdateResponse update(SongUpdateRequest songUpdateRequest, int songId);
	
	List<SongGetResponse> getAll();
	
	SongListenResponse playSong (SongListenRequest listen);

}
