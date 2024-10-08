package com.turkcell.OXIMusic.business.rules;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.dataAccess.ArtistRepository;
import com.turkcell.OXIMusic.entities.Artist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtistBusinessRules {
	private ArtistRepository artistRepository;
	
public void ArtistShouldBeExist (int artistId) {
		
		Optional<Artist> foundOptionalArtist = artistRepository.findById(artistId);
		if(foundOptionalArtist.isEmpty()) {
			throw new BusinessException(Messages.ArtistErrors.Artist_Not_Found);
		}
	}
	
	public void ArtistsShouldBeExist () {
		
		List<Artist> artistList = this.artistRepository.findAll();
		if(artistList.isEmpty()) {
			throw new BusinessException(Messages.ArtistErrors.Artists_Not_Found);
		}
	}
}
