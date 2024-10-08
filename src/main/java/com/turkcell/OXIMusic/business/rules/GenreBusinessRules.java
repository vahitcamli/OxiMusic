package com.turkcell.OXIMusic.business.rules;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.dataAccess.GenreRepository;
import com.turkcell.OXIMusic.entities.Genre;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenreBusinessRules {
	private GenreRepository genreRepository;
	
public void GenreShouldBeExist (int genreId) {
		
		Optional<Genre> foundOptionalGenre = genreRepository.findById(genreId);
		if(foundOptionalGenre.isEmpty()) {
			throw new BusinessException(Messages.GenreErrors.Genre_Not_Found);
		}
	}
	
	public void GenresShouldBeExist () {
		
		List<Genre> genreList = this.genreRepository.findAll();
		if(genreList.isEmpty()) {
			throw new BusinessException(Messages.GenreErrors.Genres_Not_Found);
		}
	}
}
