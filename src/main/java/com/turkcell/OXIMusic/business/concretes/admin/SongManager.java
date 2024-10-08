package com.turkcell.OXIMusic.business.concretes.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turkcell.OXIMusic.business.abstracts.admin.SongService;
import com.turkcell.OXIMusic.business.rules.SongBusinessRules;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.OXIMusic.dataAccess.SongRepository;
import com.turkcell.OXIMusic.dtos.requests.create.SongCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.listen.SongListenRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.SongUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.SongCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.SongGetResponse;
import com.turkcell.OXIMusic.dtos.responses.listen.SongListenResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.SongUpdateResponse;
import com.turkcell.OXIMusic.entities.Song;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongManager implements SongService{
	
	private ModelMapperService modelMapperService;
	private SongRepository songRepository;
	private SongBusinessRules songBusinessRules;
	
	
	@Override
	public SongCreateResponse add(SongCreateRequest songCreateRequest) {
		Song song = modelMapperService.forRequest().map(songCreateRequest, Song.class);
		
		song.setCreatedDate(LocalDateTime.now());
		
		Song createdSong = songRepository.save(song);
		
		return modelMapperService.forResponse().map(createdSong, SongCreateResponse.class);
	}

	@Override
	public void delete(int id) {
	songBusinessRules.SongShouldBeExist(id);
		
		Song song =this.songRepository.findById(id).get();
		
		song.setDeleted(true);
		song.setDeletedDate(LocalDateTime.now());
		
		songRepository.save(song);
		
	}

	@Override
	public SongGetResponse getById(int id) {

		songBusinessRules.SongShouldBeExist(id);
		
		Song song = songRepository.findById(id).get();
		
		SongGetResponse songGetResponse=modelMapperService.forResponse().map(song, SongGetResponse.class);
		
		return songGetResponse;
	}

	@Override
	public SongUpdateResponse update(SongUpdateRequest songUpdateRequest, int songId) {

		songBusinessRules.SongShouldBeExist(songId);
		
		Song songUpdate = songRepository.findById(songId).get();
		
		songUpdate.setDescription(songUpdateRequest.getDescription());
		songUpdate.setUpdatedDate(LocalDateTime.now());
		
		
		Song updatedSong = songRepository.save(songUpdate);
		
		return modelMapperService.forResponse().map(updatedSong, SongUpdateResponse.class);
		
	}

	@Override
	public List<SongGetResponse> getAll() {

		songBusinessRules.SongsShouldBeExist();
		
		List<Song> song = songRepository.findAll();
		
		return song.stream().map(
				songs -> modelMapperService.forResponse().map(songs, SongGetResponse.class)).toList();
	}

	 @Override
	    @Transactional
	    public SongListenResponse playSong(SongListenRequest request) {
		
		 songBusinessRules.SongShouldBeExist(request.getSongId());

	        Song song = songRepository.findById(request.getSongId()).get();

	        song.setStream(song.getStream() + 1);

	        songRepository.save(song);

	        SongListenResponse response = modelMapperService.forResponse().map(song, SongListenResponse.class);


	        response.setAlbumName(song.getAlbum() != null ? song.getAlbum().getName() : "Unknown Album");
	        response.setGenreName(song.getGenre() != null ? song.getGenre().getName() : "Unknown Genre");
	        response.setArtistName(song.getArtist() != null ? song.getArtist().getName() : "Unknown Artist");
	        response.setMessage("Playing song");

	        return response;
	    }

}
