package com.turkcell.OXIMusic.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OXIMusic.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>{

}
