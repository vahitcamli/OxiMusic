package com.turkcell.OXIMusic.business.concretes.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.admin.ArtistService;
import com.turkcell.OXIMusic.business.rules.ArtistBusinessRules;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.OXIMusic.dataAccess.ArtistRepository;
import com.turkcell.OXIMusic.dtos.requests.create.ArtistCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.ArtistUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.ArtistCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.ArtistGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.ArtistUpdateResponse;
import com.turkcell.OXIMusic.entities.Artist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtistManager implements ArtistService{
	private ModelMapperService modelMapperService;
	private ArtistRepository artistRepository;
	private ArtistBusinessRules artistBusinessRules;
	
	
	@Override
	public ArtistCreateResponse add(ArtistCreateRequest artistCreateRequest) {
		Artist artist = modelMapperService.forRequest().map(artistCreateRequest, Artist.class);
		
		artist.setCreatedDate(LocalDateTime.now());
		
		Artist createdArtist = artistRepository.save(artist);
		
		return modelMapperService.forResponse().map(createdArtist, ArtistCreateResponse.class);
	}

	@Override
	public void delete(int id) {
	artistBusinessRules.ArtistShouldBeExist(id);
		
		Artist artist =this.artistRepository.findById(id).get();
		
		artist.setDeleted(true);
		artist.setDeletedDate(LocalDateTime.now());
		
		artistRepository.save(artist);
		
	}

	@Override
	public ArtistGetResponse getById(int id) {

		artistBusinessRules.ArtistShouldBeExist(id);
		
		Artist artist = artistRepository.findById(id).get();
		
		ArtistGetResponse artistGetResponse=modelMapperService.forResponse().map(artist, ArtistGetResponse.class);
		
		return artistGetResponse;
	}

	@Override
	public ArtistUpdateResponse update(ArtistUpdateRequest artistUpdateRequest, int artistId) {

		artistBusinessRules.ArtistShouldBeExist(artistId);
		
		Artist artistUpdate = modelMapperService.forResponse().map(artistUpdateRequest, Artist.class);
		
		artistUpdate.setUpdatedDate(LocalDateTime.now());
		artistUpdate.setId(artistId);
		
		Artist updatedArtist = artistRepository.save(artistUpdate);
		
		return modelMapperService.forResponse().map(updatedArtist, ArtistUpdateResponse.class);
		
	}

	@Override
	public List<ArtistGetResponse> getAll() {

		artistBusinessRules.ArtistsShouldBeExist();
		
		List<Artist> artist = artistRepository.findAll();
		
		return artist.stream().map(
				artists -> modelMapperService.forResponse().map(artists, ArtistGetResponse.class)).toList();
	}

}
