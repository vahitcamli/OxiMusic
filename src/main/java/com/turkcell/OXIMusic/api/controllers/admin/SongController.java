package com.turkcell.OXIMusic.api.controllers.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.OXIMusic.business.abstracts.admin.SongService;
import com.turkcell.OXIMusic.dtos.requests.create.SongCreateRequest;
import com.turkcell.OXIMusic.dtos.requests.listen.SongListenRequest;
import com.turkcell.OXIMusic.dtos.requests.updates.SongUpdateRequest;
import com.turkcell.OXIMusic.dtos.responses.creates.SongCreateResponse;
import com.turkcell.OXIMusic.dtos.responses.gets.SongGetResponse;
import com.turkcell.OXIMusic.dtos.responses.listen.SongListenResponse;
import com.turkcell.OXIMusic.dtos.responses.updates.SongUpdateResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/songs")
public class SongController {

    private final SongService songService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SongCreateResponse add(
    		@Valid @RequestBody SongCreateRequest songCreateRequest) {
        return songService.add(songCreateRequest);
    }
    
    @GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public SongGetResponse getById (@PathVariable int id) {
		return songService.getById(id);
 	
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SongUpdateResponse songUpdate (@Valid @RequestBody SongUpdateRequest songUpdateRequest,@PathVariable int id) {
    	
    	return songService.update(songUpdateRequest, id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void delete(@PathVariable int id) {
    	songService.delete(id);
    }
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SongGetResponse> getAll() {
		return songService.getAll();
	}
    
    @PostMapping("/listen")
    public SongListenResponse listenSong(@RequestBody SongListenRequest listenRequest) {
        return songService.playSong(listenRequest);
    }
}