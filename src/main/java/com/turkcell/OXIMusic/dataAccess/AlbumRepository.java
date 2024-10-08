package com.turkcell.OXIMusic.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OXIMusic.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
