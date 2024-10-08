package com.turkcell.OXIMusic.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OXIMusic.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

	Optional<Song> findById(Long songId);

}
