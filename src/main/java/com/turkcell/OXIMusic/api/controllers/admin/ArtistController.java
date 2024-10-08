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

import com.turkcell.OXIMusic.business.abstracts.admin.ArtistService;
import com.turkcell.OXIMusic.dtos.requests.create.ArtistCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.ArtistUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.ArtistCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.ArtistGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.ArtistUpdateResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/artists")
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistCreateResponse add(
    		@Valid @RequestBody ArtistCreateRequest artistCreateRequest) {
        return artistService.add(artistCreateRequest);
    }
    
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ArtistGetResponse getById (@PathVariable int id) {
		return artistService.getById(id);
 	
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ArtistUpdateResponse artistUpdate (@Valid @RequestBody ArtistUpdateRequest artistUpdateRequest,@PathVariable int id) {
    	
    	return artistService.update(artistUpdateRequest, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void delete(@PathVariable int id) {
    	artistService.delete(id);
    }
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ArtistGetResponse> getAll() {
		return artistService.getAll();
	}
}