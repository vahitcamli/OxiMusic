package com.turkcell.OXIMusic.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.OXIMusic.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
