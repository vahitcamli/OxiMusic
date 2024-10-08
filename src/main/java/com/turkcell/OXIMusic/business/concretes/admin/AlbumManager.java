package com.turkcell.OXIMusic.business.concretes.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.admin.AlbumService;
import com.turkcell.OXIMusic.business.rules.AlbumBusinessRules;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.OXIMusic.dataAccess.AlbumRepository;
import com.turkcell.OXIMusic.dtos.requests.create.AlbumCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.AlbumUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.AlbumCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.AlbumGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.AlbumUpdateResponse;
import com.turkcell.OXIMusic.entities.Album;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumManager implements AlbumService{
	private ModelMapperService modelMapperService;
	private AlbumRepository albumRepository;
	private AlbumBusinessRules albumBusinessRules;
	
	
	@Override
	public AlbumCreateResponse add(AlbumCreateRequest albumCreateRequest) {
		Album album = modelMapperService.forRequest().map(albumCreateRequest, Album.class);
		
		album.setCreatedDate(LocalDateTime.now());
		
		Album createdAlbum = albumRepository.save(album);
		
		return modelMapperService.forResponse().map(createdAlbum, AlbumCreateResponse.class);
	}

	@Override
	public void delete(int id) {
	albumBusinessRules.AlbumShouldBeExist(id);
		
		Album album =this.albumRepository.findById(id).get();
		
		album.setDeleted(true);
		album.setDeletedDate(LocalDateTime.now());
		
		albumRepository.save(album);
		
	}

	@Override
	public AlbumGetResponse getById(int id) {

		albumBusinessRules.AlbumShouldBeExist(id);
		
		Album album = albumRepository.findById(id).get();
		
		AlbumGetResponse albumGetResponse=modelMapperService.forResponse().map(album, AlbumGetResponse.class);
		
		return albumGetResponse;
	}

	@Override
	public AlbumUpdateResponse update(AlbumUpdateRequest albumUpdateRequest, int albumId) {

		albumBusinessRules.AlbumShouldBeExist(albumId);
		
		Album albumUpdate = modelMapperService.forResponse().map(albumUpdateRequest, Album.class);
		
		albumUpdate.setUpdatedDate(LocalDateTime.now());
		albumUpdate.setId(albumId);
		
		Album updatedalbum = albumRepository.save(albumUpdate);
		
		return modelMapperService.forResponse().map(updatedalbum, AlbumUpdateResponse.class);
		
	}

	@Override
	public List<AlbumGetResponse> getAll() {

		albumBusinessRules.AlbumsShouldBeExist();
		
		List<Album> album = albumRepository.findAll();
		
		return album.stream().map(
				albums -> modelMapperService.forResponse().map(albums, AlbumGetResponse.class)).toList();
	}

}
