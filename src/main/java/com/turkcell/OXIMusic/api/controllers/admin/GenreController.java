package com.turkcell.OXIMusic.api.controllers.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OXIMusic.business.abstracts.admin.GenreService;
import com.turkcell.OXIMusic.dtos.requests.create.GenreCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.GenreUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.GenreCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.GenreGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.GenreUpdateResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/genres")
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreCreateResponse add(
    		@Valid @RequestBody GenreCreateRequest genreCreateRequest) {
        return genreService.add(genreCreateRequest);
    }
    
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public GenreGetResponse getById (@PathVariable int id) {
		return genreService.getById(id);
 	
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreUpdateResponse userUpdate (@Valid @RequestBody GenreUpdateRequest GenreUpdateRequest,@PathVariable int id) {
    	
    	return genreService.update(GenreUpdateRequest, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void delete(@PathVariable int id) {
    	genreService.delete(id);
    }
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GenreGetResponse> getAll() {
		return genreService.getAll();
	}
}