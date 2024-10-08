package com.turkcell.OXIMusic.business.concretes.admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.abstracts.admin.GenreService;
import com.turkcell.OXIMusic.business.rules.GenreBusinessRules;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.mapping.ModelMapperService;
import com.turkcell.OXIMusic.dataAccess.GenreRepository;
import com.turkcell.OXIMusic.dtos.requests.create.GenreCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.GenreUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.GenreCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.GenreGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.GenreUpdateResponse;
import com.turkcell.OXIMusic.entities.Genre;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GenreManager implements GenreService {
	
	private GenreBusinessRules genreBusinessRules;
	private GenreRepository genreRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public GenreCreateResponse add(GenreCreateRequest genreCreateRequest) {
		Genre genre = modelMapperService.forRequest().map(genreCreateRequest,Genre.class);
		
		genre.setCreatedDate(LocalDateTime.now());
		
		Genre createdGenre = genreRepository.save(genre);
		return modelMapperService.forResponse().map(createdGenre, GenreCreateResponse.class);
	}

	@Override
	public void delete(int id) {
		
		genreBusinessRules.GenreShouldBeExist(id);
		
		Genre genre = genreRepository.findById(id).get();
		
		genre.setDeleted(true);
		genre.setDeletedDate(LocalDateTime.now());
		
		genreRepository.save(genre);
	}

	@Override
	public GenreGetResponse getById(int id) {
		
		genreBusinessRules.GenreShouldBeExist(id);
		
		Genre genre = genreRepository.findById(id).get();
		
		GenreGetResponse genreGetResponse = modelMapperService.forResponse().map(genre, GenreGetResponse.class);
		return genreGetResponse;
	}

	@Override
	public GenreUpdateResponse update(GenreUpdateRequest genreUpdateRequest, int genreId) {
		
		genreBusinessRules.GenreShouldBeExist(genreId);
		
		Genre genreUpdate = modelMapperService.forResponse().map(genreUpdateRequest, Genre.class);
		
		genreUpdate.setUpdatedDate(LocalDateTime.now());
		
		genreUpdate.setId(genreId);
		
		Genre updatedGenre = genreRepository.save(genreUpdate);
		
		return modelMapperService.forResponse().map(updatedGenre, GenreUpdateResponse.class);
	}

	@Override
	public List<GenreGetResponse> getAll() {
		
		genreBusinessRules.GenresShouldBeExist();

		List<Genre> genres = genreRepository.findAll();
		return genres.stream().map(genre -> modelMapperService.forResponse().map(genre, GenreGetResponse.class)).toList();
	}

}
