package com.turkcell.OXIMusic.business.rules;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.dataAccess.AlbumRepository;
import com.turkcell.OXIMusic.entities.Album;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumBusinessRules {
	private AlbumRepository albumRepository;
	
public void AlbumShouldBeExist (int albumId) {
		
		Optional<Album> foundOptionalAlbum = albumRepository.findById(albumId);
		if(foundOptionalAlbum.isEmpty()) {
			throw new BusinessException(Messages.AlbumErrors.Albums_Not_Found);
		}
	}
	
	public void AlbumsShouldBeExist () {
		
		List<Album> albumList = this.albumRepository.findAll();
		if(albumList.isEmpty()) {
			throw new BusinessException(Messages.AlbumErrors.Albums_Not_Found);
		}
	}
}
