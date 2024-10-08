package com.turkcell.OXIMusic.business.rules;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.turkcell.OXIMusic.business.messages.Messages;
import com.turkcell.OXIMusic.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.OXIMusic.dataAccess.SongRepository;
import com.turkcell.OXIMusic.entities.Song;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongBusinessRules {
	private SongRepository songRepository;
	
public void SongShouldBeExist (int songId) {
		
		Optional<Song> foundOptionalSong = songRepository.findById(songId);
		if(foundOptionalSong.isEmpty()) {
			throw new BusinessException(Messages.SongErrors.Song_Not_Found);
		}
	}
	
	public void SongsShouldBeExist () {
		
		List<Song> songList = this.songRepository.findAll();
		if(songList.isEmpty()) {
			throw new BusinessException(Messages.SongErrors.Songs_Not_Found);
		}
	}

}
