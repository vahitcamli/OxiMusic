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

import com.turkcell.OXIMusic.business.abstracts.admin.AlbumService;
import com.turkcell.OXIMusic.dtos.requests.create.AlbumCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.AlbumUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.AlbumCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.AlbumGetResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.AlbumUpdateResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/albums")
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumCreateResponse add(
    		@Valid @RequestBody AlbumCreateRequest albumCreateRequest) {
        return albumService.add(albumCreateRequest);
    }
    
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public AlbumGetResponse getById (@PathVariable int id) {
		return albumService.getById(id);
 	
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumUpdateResponse albumUpdate (@Valid @RequestBody AlbumUpdateRequest AlbumUpdateRequest,@PathVariable int id) {
    	
    	return albumService.update(AlbumUpdateRequest, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void delete(@PathVariable int id) {
    	albumService.delete(id);
    }
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AlbumGetResponse> getAll() {
		return albumService.getAll();
	}
}